package com.academy.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;


import com.academy.domain.BbsVO;


public interface BbsMapper {

//	@Select("select * from bbs where bbsid > 0")
	public List<BbsVO> getList();

	//입력, 테스트 완료
	public void insert(BbsVO board);
	
	public Integer insertSelectKey(BbsVO board);
	//읽기
	public BbsVO read(Long bbsID);
	//지우기
	public int delete(Long bbsID);
	//수정하기
	public int update(BbsVO board);

}
