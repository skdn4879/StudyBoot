package com.iu.home.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotBlank(message = "ID는 꼭 필요함")
	private String id;
	@NotBlank
	@Size(max = 12, min = 6)
	private String pw;
	private String pwcheck;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	private Boolean enabled;
	private List<RoleVO> roles;
	
}
