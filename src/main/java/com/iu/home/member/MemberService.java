package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public int setJoin(MemberVO memberVO) throws Exception {
		boolean memberResult = memberMapper.setJoin(memberVO) == 1 ? true : false;
		boolean roleResult = memberMapper.setRoleJoin(memberVO) == 1 ? true : false;
		// 위 결과는 Exception이 발생해서 실패한 것이 아니다. 그냥 들어가면 1 아니면 0
		
		int result = 0;
		
		if (memberResult && roleResult) {
			result = 1;
		}
		
		if(result < 1) {
			throw new Exception();
		}
		
		return result;
	}
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
}
