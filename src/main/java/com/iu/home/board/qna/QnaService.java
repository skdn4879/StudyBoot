package com.iu.home.board.qna;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.qna}")
	private String path;
	
	// 클래스에 Transactional을 적으면 모든 메서드에 적용
	@Transactional(rollbackFor = Exception.class) // 트랜잭션 처리, Exception 발생 시 rollback
	public int setAdd(QnaVO qnaVO) throws Exception {
		
		int result = qnaMapper.setAdd(qnaVO);
		
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
			log.info("Check : {}", check);
		}
		
		//String fileName = fileManager.saveFile(qnaVO.getFiles()[1], path);
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(f.isEmpty()) {
				log.info("Exception 발생");
				throw new Exception();
			}
			
			if(!f.isEmpty()) {
				String fileName = fileManager.saveFile(f, path);
				
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				
				qnaMapper.setAddFile(qnaFileVO);
			}
		}
		
		return result;
	}
	
	public QnaVO getDetail(QnaVO qnaVO) throws Exception {
		return qnaMapper.getDetail(qnaVO);
	}
	
}
