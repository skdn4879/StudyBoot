package com.iu.home.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private QnaService qnaService;
	
	@Value("${app.upload.qna}")
	private String path;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("update")
	public ModelAndView getUpdate(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.getDetail(qnaVO);
		
		mv.addObject("qnaVO", qnaVO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public Map<String, Integer> setFileDelete(QnaFileVO qnaFileVO) throws Exception {
		int result = qnaService.setFileDelete(qnaFileVO);
		//int result = 0;
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		Long totalCount = qnaMapper.getTotalCount();
		
		pager.calRowNum();
		pager.calBlockNum(totalCount);
		
		List<QnaVO> list = qnaMapper.getList(pager);
		mv.addObject("qnaList", list);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("write")
	public String getWrite(@ModelAttribute QnaVO qnaVO) throws Exception{
		return "board/write";
	}
	
	@PostMapping("write")
	public ModelAndView setWrite(@Valid QnaVO qnaVO, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelAndView mv) throws Exception {
		qnaVO.setHit(0L);
		qnaVO.setRef(0L);
		qnaVO.setStep(0L);
		qnaVO.setDepth(0L);
		
		if(bindingResult.hasErrors()) {
			log.info("------------ Qna 검증 오류 -----------");
			mv.setViewName("board/write");
			return mv;
		}
		
		/*int result = qnaService.setAdd(qnaVO);
		log.info("Result {}", result); //로그 기록 남기기(나중에 sql log 설정시 없애도 무방)
		redirectAttributes.addAttribute("result", result);*/
		
		mv.setViewName("redirect:/qna/list");
		
		return mv;
		
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.getDetail(qnaVO);
		
		mv.addObject("qnaVO", qnaVO);
		mv.addObject("path", path);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
}
