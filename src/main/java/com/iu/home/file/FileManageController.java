package com.iu.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;
import com.iu.home.board.qna.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/fileDown/*")
@Slf4j
public class FileManageController {
	
	@Autowired
	private QnaService qnaService;

	@GetMapping("{path}")	// Restful, RestAPI와 관련있음, url 주소의 일부분을 데이터로 활용할 수 있음
	public ModelAndView fileDown(@PathVariable String path, QnaFileVO qnaFileVO) throws Exception {
		// PathVariable : url 일부를 지정된 변수명으로 활용, ex) /fileDown/qna 이면 qna가 path에 담긴다.
		// 여러개로 쓸 수도 있다. ex) /fileDown/{path}/{num} -> /fileDown/qna/3 이면 path에 qna가 num에 3(문자열)이 담긴다.
		// @PathVariable(name = "p") String path 처럼 이름을 다르게 할 수도 있다. /fileDown/{p} 이면 p에 해당하는 값이 path에 담긴다.
		// RestAPI를 제작할 때에 url에 따라 다른 정보를 표현해야 하므로 PathVariable을 쓰면 유용하다.
		log.info("Path {}", path);
		
		ModelAndView mv = new ModelAndView();
		
		// DB에서 정보 조회
		if(path.equals("qna")) {
			qnaFileVO = qnaService.getFileDetail(qnaFileVO);
		} else {
			qnaFileVO.setFileName("fd5f315b-5427-434e-b70e-ec9543835ecf_.jpg");
			qnaFileVO.setOriName("title3.jpg");
		}
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		
		mv.setViewName("fileManager"); //파일 다운로드를 다루는 Bean의 이름
		//Component에 별도의 이름을 지정하지 않으면 맨 앞글자를 소문자로 바꾼 것이 default
		// Bean 이름을 지정하면 View를 찾는 것이 아닌 해당 Bean을 실행
		// view의 이름과 일치하는 bean의 이름이있으먼 해당 객체 실행
		// 원래대로라면 WEB-INF/views/fileManager.jsp 이렇게 찾아가야 하지만
		// BeanNameResolver라는게 내장되어 있어서 이게 먼저 동작
		// view의 이름과 일치하는 bean의 이름이 있으면 해당 Bean 실행
		// 위에 Resolver가 없으면 InternalResourceViewResolver가 작동해서 jsp로 이동
		
		return mv;
		
	}
	
	/*@GetMapping("notice")
	public ModelAndView fileDownNotice(QnaFileVO qnaFileVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// DB에서 정보 조회
		qnaFileVO.setFileName("testImage.jpg");
		qnaFileVO.setOriName("testImage.jpg");
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", "notice");
		
		mv.setViewName("fileManager"); //파일 다운로드를 다루는 Bean의 이름
		//Component에 별도의 이름을 지정하지 않으면 맨 앞글자를 소문자로 바꾼 것이 default
		// Bean 이름을 지정하면 View를 찾는 것이 아닌 해당 Bean을 실행
		
		return mv;
		
	}*/
	
}
