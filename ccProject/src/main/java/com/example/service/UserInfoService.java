package com.example.service;

import com.example.domain.UsersDTO;

public interface UserInfoService {
	public UsersDTO readID(UsersDTO dto);
	public UsersDTO checkID(String id);
	public int insertID(UsersDTO dto);
	public int updateID(UsersDTO dto);
	public int deleteID(UsersDTO dto);
	
}
