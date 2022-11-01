package com.academy.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 서블릿 콘텍스트를 사용하겠다는 의미
@ContextConfiguration(classes = { com.academy.config.RootConfig.class, 
								  com.academy.config.ServletConfig.class })
@Log4j
public class BbsControllerTest {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc; // 가짜 MVC - url과 파라미터를 브라우저 사용처람 만들어 컨트롤러 실행

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

//	@Test // 1.입력 테스트
	public void testRegister() throws Exception {
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
												.post("/board/register")
												.param("BbsTitle", "테스트 새글 제목")
												.param("BbsContent", "테스트 새글 내용")
												.param("Userid", "guest")
												.param("Studycode", "1")
												)
										.andReturn()
										.getModelAndView()
										.getViewName();
		log.info(resultPage);
	}
	
//	@Test//2.조회 테스트
	public void tetGet() throws Exception {
		
		log.info(mockMvc.perform(MockMvcRequestBuilders
						.get("/board/get")
						.param("bbsID", "15"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				
				);
	}
//	@Test//3.수정테스트
	public void testModify() throws Exception{
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
										.post("/board/modify")
										.param("bbsID", "1")
										.param("BbsTitle", "수정된 테스트 새글 제목")
										.param("BbsContent", "수정된 테스트 새글 내용")
										.param("Userid", "guest"))
							.andReturn()
							.getModelAndView()
							.getViewName();
		log.info(resultPage);
	}
	@Test//4.삭제 테스트
	public void testRemove() throws Exception{
		//삭제전 데이터베이스에 게시물 번호 확인하기
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
									.post("/board/remove")
									.param("bbsID", "12"))
							.andReturn()
							.getModelAndView()
							.getViewName();
		log.info(resultPage);
	}
//	@Test
	public void testListPaginf() throws Exception{ 
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "5"))
				.andReturn().getModelAndView().getModelMap());
	}
	
	
	
	
}
