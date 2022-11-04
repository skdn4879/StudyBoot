package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.iu.home.member.security.LoginFail;
import com.iu.home.member.security.LoginSuccess;
import com.iu.home.member.security.LogoutCustom;
import com.iu.home.member.security.LogoutSuccessCustom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private LoginSuccess loginSuccess;
	
	@Autowired
	private LoginFail loginFail;
	
	@Autowired
	private LogoutCustom logoutCustom;
	
	@Autowired
	private LogoutSuccessCustom logoutSuccessCustom;

	@Bean
	//public 선언 시 default로 바꾸라는 메시지 출력
	WebSecurityCustomizer webSecurityConfig() {
		
		//ignoring() 보안과 관련 없는 사항이라 무시
		//antMatchers : /images/로 시작하는 url 요청은 보안이랑 관련 없으니 무시
		//Security에서 무시해야하는 URL 패턴 등록
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/favicon/**")
				.antMatchers("/file/**")
				.antMatchers("/resources/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.cors()
				.and()
				.csrf()
				.disable()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/manager").hasRole("MANAGER")
				.antMatchers("/qna/list").permitAll()
				.antMatchers("/qna/**").hasRole("MEMBER")	// qna/list는 모두 허용하지만 나머지는 MEMBER Role을 가져야 허용(순서 중요, 순서바뀌면 list도 막힘)
				.anyRequest().authenticated()	// 그 외 나머지는 인증된(로그인된) 사용자만 허용
				.and()
			.formLogin()	//로그인 폼 인증 설정
				.loginPage("/member/login")		// 내장된 로그인폼을 사용하지 않고, 개발자가 만든 폼 요청 URL
				//.loginProcessingUrl("login") 	// 로그인을 진행 요청할 form 태그의 action의 주소 지정
				.passwordParameter("pw")		// 기본 파라미터인 password가 아닌 pw를 사용
				.usernameParameter("id")		// 기본 파라미터인 username 대신 id를 사용
				//.defaultSuccessUrl("/") 		// 인증 성공할 경우 요청할 URL
				.successHandler(loginSuccess)
				//.failureUrl("/member/login?error=true&message=LoginFail")	// 인증 실패했을 경우 요청할 URL
				.failureHandler(loginFail)
				.permitAll() 					// 로그인 페이지는 모두 허용
				.and()
			.logout()		//로그아웃 페이지도 모두 허용
				.logoutUrl("/member/logout")
				.logoutSuccessUrl("/")
				.logoutSuccessHandler(logoutSuccessCustom)
				.addLogoutHandler(logoutCustom)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll();
		// 보통 막을 거를 위에서 다 막고 나머지를 허용하는 방식으로 사용 (막을거 위, 안막을거 아래)
		
		return httpSecurity.build();
	}
	
	// 평문(Clear Text)을 암호화 시켜주는 객체 생성
	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
