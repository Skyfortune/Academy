package com.academy.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.academy.domain.BbsVO;
//import com.academy.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.academy.config.RootConfig.class })
@Log4j
public class BbsMapperTest {

	@Setter(onMethod_ = @Autowired)
	private BbsMapper mapper;

//	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

//	@Test
	public void testInsert() {

		BbsVO board = new BbsVO();
		board.setBbsTitle("새로 작성 하는 글");
		board.setBbsContent("새로 작성하는 내용");
		board.setUserid("guest");
		board.setStudycode("1");
		
		mapper.insert(board);

		log.info(board);
	}

//	@Test
	public void testInsertSelectKey() {

		BbsVO board = new BbsVO();
		board.setBbsTitle("새로 작성 하는 글 select key");
		board.setBbsContent("새로 작성하는 내용 select key");
		board.setUserid("guest");
		board.setStudycode("1");
		

		mapper.insertSelectKey(board);

		log.info(board);
	}

//	@Test
	public void testRead() {

		// 존재하는 게시물 번호 테스트

		BbsVO board = mapper.read(12L);

		log.info(board);
	}

//	@Test
	public void testDelete() {

		log.info("DELETE COUNT: " + mapper.delete(14L));
	}

//	@Test
	public void testUpdate() {
		BbsVO board = new BbsVO();
		// 실행전 존재하는 번호인지 확인하기
		board.setBbsID(12L);
		board.setBbsTitle("수정된 제목");
		board.setBbsContent("수정된 내용");
//		board.setWriter("user00");

		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}

	/*
	 * @Test public void testPaging() { Criteria cri = new Criteria();
	 * 
	 * // 10개씩 3페이지 cri.setPageNum(1); cri.setAmount(5);
	 * 
	 * List<BoardVO> list = mapper.getListWithPaging(cri);
	 * 
	 * list.forEach(board -> log.info(board)); }
	 */

}
