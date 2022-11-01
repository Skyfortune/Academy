package com.example.mapper;

import java.util.Date;

import com.example.domain.AttendanceDTO;

public interface CCMapper {
	public AttendanceDTO getTotalDate(String startDate, String endDate);
	public AttendanceDTO getCurrentDate(Date startDate, Date endDate);
	public AttendanceDTO getCheckDate(String userId, Date startDate, Date endDate);
	
	public Date getStartDate(Date date);
	public Date getEndDate(Date date);
	
	
}
