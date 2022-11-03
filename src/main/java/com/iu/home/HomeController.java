package com.iu.home;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iu.home.board.qna.QnaMapper;
import com.iu.home.board.qna.QnaVO;
import com.iu.home.member.MemberVO;

@Controller
public class HomeController {
	
	//private final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass()); //자기 자신의 클래스
	
	//@Value("${my.message.hi}")
	private String message;
	
	@Value("${my.default}")
	private String app;
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin Role";
	}
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "Manager Role";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String member() {
		return "Member Role";
	}
	
	@GetMapping("/")
	public String home(HttpSession session) throws Exception {
		
		log.info("----------------------------------------------");
		
		Enumeration<String> en = session.getAttributeNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			log.info("Key => {}", key);
		}
		
		// 기존 로그인에서는 우리가 직접 session에 넣어주었는데 Security도 session을 사용한다.
		// 단, Security의 고정된 이름을 사용한다.
		
		//Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
		//log.info("Obj => {}", obj);
		
		// SecurityContextImpl 은 SecurityContext를 구현한 구현체임을 이름에서 알 수 있다.
		// 따라서 다형성에 의해 SecurityContext 타입이다.
		//SecurityContext context = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		SecurityContextImpl context = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		if (context != null) {
			log.info("Context => {}", context);
			log.info("Context => {}", ((MemberVO)context.getAuthentication().getPrincipal()).getId());
		}
		
		log.info("Message : {}", message);
		log.info("Default : {}", app);
		log.info("----------------------------------------------");
		
		return "index";
	}
	
}
