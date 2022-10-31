package com.academy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AttendanceVO {

	private Date attendanceDate; //출석 날짜
	private Date attendanceJoin;  //입실 시간
	private Date attendanceExit;  //퇴실시간
//	private String studycode;   //스터디에서 가져오기
//	private String userid;		//유저에서 가져오기
	
}