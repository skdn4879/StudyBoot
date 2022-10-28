package com.iu.home.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("idCheck")
	@ResponseBody
	public Map<String, Integer> getIdCheck(MemberVO memberVO) throws Exception {
		int result = memberService.getIdCheck(memberVO);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception {
		//session.removeAttribute("member");
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public String getLogin() throws Exception {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session) throws Exception {
		memberVO = memberService.getLogin(memberVO);
		
		session.setAttribute("member", memberVO);
		
		return "redirect:/";
	}

	@GetMapping("join")
	public String getJoin(@ModelAttribute MemberVO memberVO) throws Exception{
		return "member/join";
	}
	
	@PostMapping("join")
	public ModelAndView setJoin(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv) throws Exception {
		// memberVO를 검증하고 결과를 bindingResult에 담는다.
		// 순서 중요함, 검증하는 대상 바로 뒤에 BindingResult를 선언, 중간에 다른게 끼면 안된다.
		
		// 검증 결과를 이용한 로직
		if(bindingResult.hasErrors()) {
			// 검증에 실패하면 회원가입 jsp로 forward
			log.info("----------------- 검증 에러 발생 -------------------");
			mv.setViewName("member/join");
			return mv;
		}
		
		//int result = memberService.setJoin(memberVO);
		
		//mv.addObject("result", result);
		mv.setViewName("redirect:/member/login");
		
		return mv;
	}
	
}
