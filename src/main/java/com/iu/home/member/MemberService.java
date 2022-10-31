package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public int getIdCheck(MemberVO memberVO) throws Exception {
		return memberMapper.getIdCheck(memberVO);
	}
	
	// 사용자 정의 검증 메소드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean check = false;
		// check = false : 검증성공(error 없음)
		// check = true  : 검증실패(error 있음)
		
		//1. annotation 검증
		// bindingResult.hasErrors()는 Annotation 검증에서의 에러 유무만 가짐
		check = bindingResult.hasErrors();
		
		//2. password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPwcheck())) {
			check = true;
			
			//에러 메시지
			//bindingResult.rejectValue("멤버변수명(path)", "properties의 key(코드)");
			bindingResult.rejectValue("pwcheck", "member.password.notEqual");
		}
		
		//3. id가 중복인지 검증
		if(this.getIdCheck(memberVO) == 1) {
			check = true;
			bindingResult.rejectValue("id", "member.id.overLap");
		}
		
		return check;
	}
	
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
