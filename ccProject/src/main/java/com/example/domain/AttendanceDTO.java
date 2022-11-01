package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AttendanceDTO {
	private Date totalDate;
	private Date currentDate;
	private Date checkDate;
}
