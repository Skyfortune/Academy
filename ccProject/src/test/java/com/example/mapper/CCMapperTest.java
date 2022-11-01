package com.example.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AttendanceDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = {com.example.config.RootConfig.class})
@Log4j
public class CCMapperTest {
	@Setter(onMethod_ = @Autowired)
	private CCMapper mapper;
	
	@Test
	public void test() {
		AttendanceDTO dto = mapper.getTotalDate("20221101", "20221231");
		log.info(dto);
	}
}
