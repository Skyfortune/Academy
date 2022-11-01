package com.academy.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.academy.domain.BbsVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.academy.config.RootConfig.class })
@Log4j
public class BbsServiceTest {

	@Setter(onMethod_ = { @Autowired })
	private BbsService service;

//	@Test
	public void testExist() {

		log.info(service);
		assertNotNull(service);
	}

	@Test
	public void testRegister() {

		BbsVO board = new BbsVO();
		board.setBbsTitle("새로 작성하는 글");
		board.setBbsContent("새로 작성하는 내용");
		board.setUserid("newbie");

		service.register(board);

		log.info("생성된 게시물의 번호: " + board.getBbsID());
	}

//	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
//		service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}

//	@Test
	public void testget() {
		log.info(service.get(1L));
	}

//	@Test	
	public void testDelete() {
		// 게시물 번호의 존배 여부를 확인하고 테스트할 것]
		log.info("REMOVE RESULT: " + service.remove(2L));
	}

//	@Test	
	public void testUpdate() {
		BbsVO board = service.get(1L);
		if (board == null) {
			return;
		}

		board.setBbsTitle("제목 수정합니다.");
		log.info("MODIFY RESULT " + service.modify(board));

	}

}
