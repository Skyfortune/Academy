package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class StudyDTO {
	private String studyCode;
	private String studyCourse;
	private String studyContent;
	private Date studyStartDate;
	private Date studyEndDate;
	private Date studyStartTime; 
	private Date studyEndTime;
	private String studyTeacher;
	private int studyPrice;
	
	
}
