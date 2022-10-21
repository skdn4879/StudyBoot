package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${my.default}")
	private String app;
	
	@Test
	void test3() throws Exception {
		log.info("Default : {}", app);
	}
	
	/*@Autowired
	private QnaMapper qnaMapper;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private QnaVO qnaVO;
	
	@BeforeAll
	static void befoAll() {
		System.out.println("전체 Test 실행 전 !!!!");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("전체 Test 실행 후 !!!!");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Test 메소드 실행 전");
		//qnaVO = new QnaVO();
		//qnaVO.setContents("contents");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("Test 메소드 실행 후");
	}*/

	/*@Test
	void test() throws Exception {
		List<QnaVO> ar = qnaMapper.getList();
		log.info("List {}, size {}", ar, ar.size());
		assertNotEquals(0, ar.size());
	}*/
	
	/*@Test
	void test2() {
		log.info("Test2 Case");
	}
	
	@Test
	void insertTest() throws Exception {
		
		for(int i = 0; i < 100; i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("title" + i);
			qnaVO.setContents("contents" + i);
			qnaVO.setWriter("writer" + i);
			qnaVO.setHit(0L);
			qnaVO.setRef(0L);
			qnaVO.setStep(0L);
			qnaVO.setDepth(0L);
			
			int result = qnaMapper.setAdd(qnaVO);
		}
		
	}*/

}
