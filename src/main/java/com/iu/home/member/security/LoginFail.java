package com.iu.home.member.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginFail implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		log.info("--------- 로그인 실패 ---------");
		log.info("LocalMessage => {}", exception.getLocalizedMessage());
		log.info("Cause => {}", exception.getCause());
		log.info("Message => {}", exception.getMessage());
		
		/*String exceptionName = exception.getClass().toString();
		exceptionName = exceptionName.substring(exceptionName.lastIndexOf("."));
		if (exceptionName.equals(".BadCredentialsException")) {
			exceptionName = "비번 틀림";
		}
		exceptionName = URLEncoder.encode(exceptionName, "UTF-8");*/
		
		String result = null;
		// 변수명 instanceof 클래스명 : 해당 변수가 클래스 타입인 경우
		if(exception instanceof BadCredentialsException) {
			result = "비번 틀림";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			result = "없는 ID";
		} else {
			result = "로그인 실패";
		}
		result = URLEncoder.encode(result, "UTF-8");
		response.sendRedirect("/member/login?error=true&message=" + result);
		
		// JSP를 바로 찾아감
		/*request.setAttribute("msg", result);
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);*/
		
		// POST 방식으로 Controller의 메서드를 요청함
		//request.getRequestDispatcher("/member/login?message=" + result).forward(request, response);
		
	}
	
}
