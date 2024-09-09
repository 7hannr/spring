package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.*;
import com.example.domain.*;

@SpringBootTest
public class MysqlTest {
	@Autowired
	UserDAO dao;
	
	@Autowired
	BBSDAO bdao;
	
	@Autowired
	ReplyDAO rdao;
	
	@Autowired
	MessageDAO mdao;
	
	@Autowired
	AccountDAO adao;
	
	@Test
	public void test() {
		adao.read("red");
		//adao.list();
	}
}
