package com.academy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class StudyVO {

	private String studyCode;   //과목 코드	시퀀스를 사용하기 위해 number형
	private String studyCourse;	//과목 분류 
	private String studyContent;//과목 설명, 총 4,000자
	private Date studyStartDate;     //과목의 시작 날짜, 나중에는 not null로 변경
	private Date studyEndDate;       //과목의 종료 날짜, 나중에는 not null로 변경
	private Date studyStartTime;     //과목의 시작 시간, 나중에는 not null로 변경
	private Date studyEndTime;     //과목의 시작 시간, 나중에는 not null로 변경
	private String studyTeacher;   //과목 담당 선생님
	private int studyprice;		//과목의 가격 최대 8자리
	
	private int studyDuration; //수강이 며칠동안 이어지는지, studyDateStart에 연산해서 사용.
	private Date studyPredate;  //모집 기간. date ~ date 같은 포맷으로 사용할 수 있을 것** 이를 시작일로 설정하고, 모집 기간을 정수형으로 넣어주자.
	private int studyPredateDuration; //수강이 몇일동안 이어지는지, 
}