package com.iu.home.schedule;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.home.member.MemberService;
import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestSchedule {
	
	@Autowired
	private MemberService memberService;
	
	@Scheduled(cron = "30 * * * * *")
	public void cron() throws Exception {
		log.info("30초 실행");
		log.info(Calendar.getInstance().getTime().toString());
		MemberVO memberVO = new MemberVO();
		memberVO.setId("AutoId" + Calendar.getInstance().getTimeInMillis());
		memberVO.setPw("123456");
		memberVO.setName("Name");
		memberVO.setEmail("Email@email.com");
		log.info("Result {}", memberService.setJoin(memberVO));
	}
	
	//@Scheduled(fixedRate = 3000, initialDelayString = "1000")
	public void ts1() {
		log.info("Schedule 실행");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
