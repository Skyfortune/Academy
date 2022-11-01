package com.academy.domain;


import lombok.Data;

@Data
public class AllowVO {

	private long studyAllow; //허가 코드 {0,1}
	private String comments; //코드에 따른 메세지
}