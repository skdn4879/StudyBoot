package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
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
	public String getJoin() throws Exception{
		return "member/join";
	}
	
	@PostMapping("join")
	public ModelAndView setJoin(MemberVO memberVO) throws Exception {
		int result = memberService.setJoin(memberVO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("redirect:/member/login");
		
		return mv;
	}
	
}
