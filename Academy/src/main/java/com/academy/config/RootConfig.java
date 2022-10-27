package com.academy.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = { "com.academy.service" })
@MapperScan(basePackages = { "com.academy.mapper" })
public class RootConfig {

	@Bean
	public DataSource dataSource() throws Exception {
		HikariConfig hikariConfig = new HikariConfig();
		// hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		// hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");

		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:orcl");
		hikariConfig.setUsername("spring");
		hikariConfig.setPassword("spring");
		
		//여기에서 오류창이 출력한다, 드라이버를 못 찾음
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		System.out.println("over here! "+ dataSource.toString());
		return dataSource;
	}

	// 대문자 소문자 구분에서 빨간줄이 떴었음, 좀더 줄여서 sqlSessionFactory를 줄여서 쓰는방법도 있겠다
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
}
//테스트