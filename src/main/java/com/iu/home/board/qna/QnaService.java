package com.iu.home.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	public int setAdd(QnaVO qnaVO) throws Exception {
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info(f.getOriginalFilename());
			}
		}
		
		//int result = qnaMapper.setAdd(qnaVO);
		
		return 1;
	}
	
}
