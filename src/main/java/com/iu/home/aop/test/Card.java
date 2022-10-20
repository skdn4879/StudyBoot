package com.iu.home.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class Card {

	// 해당 패키지의 클래스의 get으로 시작하는 모든 메서드가 실행되고 난 후 실행
	/*@After("execution(* com.iu.home.aop.test.Transport.get*())")
	public void cardCheck() {
		log.info("--- 삐빅 ---");
	}*/
	
	@Before("execution(* com.iu.home.aop.test.Transport.airPlane())")
	public void before() {
		log.info("--- Before ---");
	}
	
	@After("execution(* com.iu.home.aop.test.Transport.get*())")
	public void after() {
		log.info("--- After ---");
	}
	
	@Around("execution(* com.iu.home.aop.test.Transport.take*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("--- 삐빅 승차입니다. ---");
		Object obj = joinPoint.proceed();
		log.info("--- 삐빅 하차입니다. ---");
		return obj;
	}
	
	//@AfterThrowing("execution(* com.iu.home.board.qna.QnaService.set*())")
	//@AfterThrowing("execution(* com.iu.home.board.*.*Service.set*())")
	
}
