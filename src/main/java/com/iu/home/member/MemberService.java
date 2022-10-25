package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public int setJoin(MemberVO memberVO) throws Exception {
		boolean memberResult = memberMapper.setJoin(memberVO) == 1 ? true : false;
		boolean roleResult = memberMapper.setRoleJoin(memberVO) == 1 ? true : false;
		
		int result = 0;
		
		if (memberResult && roleResult) {
			result = 1;
		}
		
		return result;
	}
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
}
