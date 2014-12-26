/*package com.nhnent.board.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import com.nhnent.board.vo.BoardEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoImplTest {

	BoardDao boardDao;

	@org.junit.Before
	public void setUp() {
		boardDao = new BoardDaoImpl();
	}
	
	@Test
	public void testInsert() throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail("aa@aa.com").setPassword("11").setBody("aa");
		
		assertTrue(true);
	}
}
*/