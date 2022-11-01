package com.example.service;

import java.util.Date;

import com.example.domain.AttendanceDTO;

public interface CCService {
	public AttendanceDTO getTotalDate(String startDate, String endDate);
	public AttendanceDTO getCurrentDate(Date startDate, Date endDate);
	public AttendanceDTO getCheckDate(String userId, Date startDate, Date endDate);
}
