package com.academy.service;

import java.util.List;

import com.academy.domain.BbsVO;


public interface BbsService {

	public void register(BbsVO board);

	public BbsVO get(Long bno);

	public boolean modify(BbsVO board);

	public boolean remove(Long bno);

	public List<BbsVO> getList();
	
}
