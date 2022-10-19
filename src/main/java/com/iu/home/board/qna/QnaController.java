package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaMapper qnaMapper;
	
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
	
}
