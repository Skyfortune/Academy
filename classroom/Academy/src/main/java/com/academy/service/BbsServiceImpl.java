package com.academy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academy.domain.BbsVO;
import com.academy.mapper.BbsMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BbsServiceImpl implements BbsService {

	private BbsMapper mapper;
	
	@Override
	public void register(BbsVO board) {
		log.info("register....." + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BbsVO get(Long bbsID) {
		log.info("get...." + bbsID);
		return mapper.read(bbsID);
	}

	@Override
	public boolean modify(BbsVO board) {
		log.info("modify....." + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bbsID) {
		log.info("remove..." + bbsID);
		return mapper.delete(bbsID) == 1;
	}

	@Override
	public List<BbsVO> getList() {
		log.info("getList.....");
		return mapper.getList();
	}

}
