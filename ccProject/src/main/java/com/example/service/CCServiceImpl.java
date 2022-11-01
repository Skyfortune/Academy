package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.AttendanceDTO;
import com.example.mapper.CCMapper;
import com.example.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CCServiceImpl implements CCService{
	@Setter(onMethod_ = @Autowired)
	private CCMapper mapper;
	
	@Override
	public AttendanceDTO getTotalDate(String startDate, String endDate) {
		
		return mapper.getTotalDate(startDate, endDate);
	}

	@Override
	public AttendanceDTO getCurrentDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return mapper.getCurrentDate(startDate, endDate);
	}

	@Override
	public AttendanceDTO getCheckDate(String userId, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return mapper.getCheckDate(userId, startDate, endDate);
	}

}
