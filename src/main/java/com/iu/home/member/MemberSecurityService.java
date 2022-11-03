package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSecurityService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper; 	// DI : MemberSecurityService는 memberMapper가 있어야 자신의 기능을 다함
										// MemberSecurityService는 memberMapper 대해 의존성을 가짐
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*MemberVO memberVO = new MemberVO();
		memberVO.setId(username);*/
		log.info("--------------- 로그인 시도 ----------------");
		MemberVO memberVO = memberMapper.getLogin(username);
		log.info("MemberVO => {}", memberVO);
		return memberVO;
	}
	
}
