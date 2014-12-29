package com.nhnent.board.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhnent.board.vo.BoardEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/test/resources/com/nhnent/board/*.xml"})
public class BoardDaoImplTest {

	@Autowired
	BoardDao boardDao;
	
	@Test
	public void testInsert() throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail("aa@aa.com").setPassword("11").setBody("aa");
		
		int no = boardDao.insert(be);

		try {
			BoardEntity temp = boardDao.selectOne(no);
			assertThat(be.getEmail(), is(temp.getEmail()));
			assertThat(be.getBody(), is(temp.getBody()));
		}finally {
			boardDao.delete(no);
		}
	}
	
	@Test
	public void testDelete() throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail("aa@aa.com").setPassword("11").setBody("aa");
		
		int no = boardDao.insert(be);
		
		boardDao.delete(no);
		
		BoardEntity temp = boardDao.selectOne(no);
		assertNull(temp);
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail("aa@aa.com").setPassword("11").setBody("aa");
		
		int no = boardDao.insert(be);
		
		be.setBody("dddd");

		try {
			boardDao.update(be);
			BoardEntity temp = boardDao.selectOne(no);
			assertThat(be.getEmail(), is(temp.getEmail()));
			assertThat(be.getBody(), is(temp.getBody()));
		}finally {
			boardDao.delete(no);
		}
	}
	
	@Test
	public void testSelectList() throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail("aa@aa.com").setPassword("11").setBody("aa");
		BoardEntity be2 = new BoardEntity();
		be2.setEmail("bb@bb.com").setPassword("22").setBody("cc");
		
		int no1 = boardDao.insert(be);
		Thread.sleep(1);
		int no2 = boardDao.insert(be2);
		
		try {
			List<BoardEntity> tempList = boardDao.selectList();
			
			assertThat(be2.getEmail(), is(tempList.get(0).getEmail()));
			assertThat(be2.getBody(), is(tempList.get(0).getBody()));
		}finally {
			boardDao.delete(no1);
			boardDao.delete(no2);
		}
	}
	
	@Test
	public void testSelectPassword() throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail("aa@aa.com").setPassword("11").setBody("aa");
		
		int no = boardDao.insert(be);
		
		try {
			BoardEntity temp = boardDao.selectPassword(no);
			
			assertThat(be.getPassword(), is(temp.getPassword()));
		} finally {
			boardDao.delete(no);
		}
	}

}
