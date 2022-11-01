package com.academy.domain;


import lombok.Data;

@Data
public class UserVO {

	private long user_seq;		//1부터 시작해서 하나씩 증가 
	private String userid;		 //아이디	
	private String userpassword; //비밀번호
	private String username;	//이름
	private String useraddress;	//주소
	private String userphone;	//휴대폰 번호
}