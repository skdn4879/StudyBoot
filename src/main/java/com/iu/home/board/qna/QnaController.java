package com.iu.home.board.qna;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
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
	public String getWrite() throws Exception{
		return "board/write";
	}
	
	@PostMapping("write")
	public String setWrite(QnaVO qnaVO, RedirectAttributes redirectAttributes) throws Exception {
		qnaVO.setHit(0L);
		qnaVO.setRef(0L);
		qnaVO.setStep(0L);
		qnaVO.setDepth(0L);
		
		int result = qnaService.setAdd(qnaVO);
		log.info("Result {}", result); //로그 기록 남기기(나중에 sql log 설정시 없애도 무방)
		redirectAttributes.addAttribute("result", result);
		
		return "redirect:/qna/list";
		
	}
	
}
