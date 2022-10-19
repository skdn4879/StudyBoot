package com.iu.home.util;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Pager {

	private Long startRow;
	private Long startNum;
	private Long lastNum;
	private Long perPage;
	private Long perBlock;
	private Long page;
	private Long totalBlock;
	private Long curBlock;
	
	private boolean pre;
	private boolean next;
	
	public void calRowNum() {
		this.startRow = (this.getPage() - 1) * this.getPerPage();
	}
	
	public void calBlockNum(Long totalCount) {
		Long totalPage = totalCount / this.getPerPage();
		
		if(totalCount % this.getPerPage() > 0) {
			totalPage++;
		}
		
		this.totalBlock = totalPage / this.getPerBlock();
		
		if(totalPage % this.getPerBlock() > 0) {
			this.totalBlock += 1;
		}
		
		this.curBlock = this.getPage() / this.getPerBlock();
		if(this.getPage() % this.getPerBlock() > 0) {
			this.curBlock += 1;
		}
		
		this.startNum = ((this.getCurBlock() - 1) * 5) + 1;
		this.lastNum = this.getCurBlock() * 5;
		
		if(this.lastNum > totalPage) {
			this.lastNum = totalPage;
		}
		
		if(this.getCurBlock() > 1) {
			pre = true;
		} else {
			pre = false;
		}
		
		if(this.getCurBlock() >= this.getTotalBlock()) {
			next = false;
		} else {
			next = true;
		}
		
	}
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return this.page;
	}
	
	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		return this.perPage;
	}
	
	public Long getPerBlock() {
		if(this.perBlock == null) {
			this.perBlock = 5L;
		}
		return this.perBlock;
	}
	
}
