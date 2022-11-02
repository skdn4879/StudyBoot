package com.iu.home.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{
	// SpringSecurity는 우리가 어떤 객체로 인증을 진행할 것인지 모르기 때문에
	// 규격된 인터페이스( UserDetails )를 구현한 구현 클래스를 이용하고 한다.
	
	@NotBlank(message = "ID는 꼭 필요함")
	private String id;
	@NotBlank
	@Size(max = 12, min = 6)
	private String pw;
	private String pwcheck;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	private Boolean enabled;
	private List<RoleVO> roles;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// ? : Any, 어떤 타입이든 가능
		// <? super T> : T나 T를 포함하는 부모들 타입 중 어떤 타입이든 가능
		// 위의 경우 GrantedAuthority 타입이나 GrantedAuthority을 상속받는 자식 타입 중 어떤 타입이든 가능
		// List는 Collection 타입
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		// 우리 Member의 Role 정보는 roles 멤버에 있음
		for(RoleVO roleVO : roles) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return authorities;
	}
	@Override
	public String getPassword() {
		
		return this.pw;
	}
	@Override
	public String getUsername() {
		
		return this.id;
	}
	@Override
	public boolean isAccountNonExpired() {
		// 계정의 만료 여부
		// true : 만료 안됨
		// false : 만료 됨, 로그인 불가
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// 계정의 잠김 여부
		// true : 계정이 잠기지 않음
		// false : 계정이 잠김, 로그인 불가
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// 패스워드 만료 여부
		// true : 만료 안됨
		// false : 만료 됨, 로그인 불가
		return true;
	}
	@Override
	public boolean isEnabled() {
		// 계정 사용 여부
		// true : 계정 활성화(계정 사용 가능)
		// false : 계정 비활성화(계정 사용 불가)
		return true;
	}
	
	
	
}
