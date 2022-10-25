package com.iu.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager extends AbstractView {
	
	@Value("${app.download.base}")
	private String base;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 다운로드를 걸어주는 메소드
		// 다운로드는 html문서처럼 문자열이 아닌 이진코드를 리턴해야함, 실제 파일은 이진코드로 네트워크를 통해 전송
		// Socket으로 Stream으로 보내서 Socket으로 Stream으로 받는다.
		
		// 이 메소드를 사용하려는 곳에서 AddObject로 보내면 model에 담긴다.
		QnaFileVO qnaFileVO = (QnaFileVO)model.get("fileVO");
		String path = (String)model.get("path");
		log.info("-----------------------------------------");
		log.info("FileVO {}", qnaFileVO);
		
		File file = new File(base + path, qnaFileVO.getFileName());
		
		// 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		// 총 파일의 크기
		response.setContentLengthLong(file.length());
		
		// 다운로드시 파일의 이름을 인코딩
		String oriName = URLEncoder.encode(qnaFileVO.getOriName(), "UTF-8");
		
		// header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\"" + oriName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// HDD에서 파일을 읽고
		FileInputStream fi = new FileInputStream(file);
		// Client로 전송 (Client로 연결된 Stream이 필요)
		OutputStream os = response.getOutputStream();
		
		// 실제 전송
		FileCopyUtils.copy(fi, os);
		
		// 자원 해제
		os.close();
		fi.close();
		
	}

	public String saveFile(MultipartFile multipartFile, String path) throws Exception {
		
		// 1. 중복되지 않는 파일명 생성 (UUID, Date의 Millisecond)
		String fileName = UUID.randomUUID().toString();
		
		// 2. 확장자
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		//bf.append(multipartFile.getOriginalFilename());
		
		// 파일명과 확장자 분리
		String ex = multipartFile.getOriginalFilename();
		ex = ex.substring(ex.lastIndexOf("."));
		// 확장자는 . 뒤에 나오니 .의 인덱스 위치를 찾고 endIndex를 지정하지 않아서
		// 끝까지 잘라온다. lastIndexOf를 쓰는 이유는 확장자는 파일명 뒤부터 찾는 것이 유리하기 때문
		
		bf.append(ex);
		
		fileName = bf.toString();
		
		// 3. File Save
		File file = new File(path, bf.toString());
		
		// FileCopyUtils
		// MultopartFile
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		multipartFile.transferTo(file);
		
		return fileName;
		
	}
	
}
