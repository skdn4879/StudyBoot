package com.iu.home.aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.iu.home.board.qna.QnaVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class QnaAdvice {

	@Before("execution(* com.iu.home.board.qna.QnaService.get*(..))")
	public void beforeTest(JoinPoint joinPoint) {
		log.info("----------------------------- Before -------------------------------");
		log.info("Args : {}", joinPoint.getArgs());
		log.info("Kind : {}", joinPoint.getKind());
	}
	
	@After("execution(* com.iu.home.board.qna.QnaService.get*(..))")
	public void afterTest(JoinPoint joinPoint) {
		log.info("----------------------------- After -------------------------------");
		log.info("Args : {}", joinPoint.getArgs());
		log.info("Kind : {}", joinPoint.getKind());
	}
	
	//@Around("execution(* com.iu.home.board.qna.QnaService.set*(..))")
	public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable {
		// ProceedingJoinPoint는 Around 만 가능
		// joinPoint는 point-cut으로 지정된 핵심 로직을 객체화시킨 것
		log.info("----------------------------- Before -------------------------------");
		log.info("Target : {}", joinPoint.getTarget()); // 핵심 로직의 클래스 객체
		log.info("This : {}", joinPoint.getThis());		// 핵심 로직의 클래스 객체
		log.info("Args : {}", joinPoint.getArgs()); // 핵심 로직의 매개변수들, point-cut으로 전달되는 매개변수의 인자값
		Object [] args = joinPoint.getArgs();
		QnaVO qnaVO = (QnaVO)args[0];
		
		Object obj = joinPoint.proceed(); // joinPoint로 지정된 핵심 로직을 실행하는 메소드
		
		log.info("----------------------------- After -------------------------------");
		log.info("Obj : {}", obj); // 핵심 로직의 return 값
		return obj;
	}
	
}
