package com.nhnent.board;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nhnent.board.dao.BoardDao;
import com.nhnent.board.vo.BoardEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
				"file:src/test/resources/com/nhnent/board/*.xml",
				"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class BoardControllerTest {	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	BoardDao boardDao;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		// TODO Auto-generated method stub
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testAddEntity() throws Exception {
		mockMvc.perform(post("/add")
				.param("email", "aa@aa.com")
				.param("password", "aa")
				.param("body", "aa")
				)
			.andExpect(status().is(302));
		
		List<BoardEntity> list = boardDao.selectList();
		try {
			assertThat(list.get(0).getEmail(), is("aa@aa.com"));
			assertThat(list.get(0).getBody(), is("aa"));
		} finally {
			boardDao.delete(list.get(0).getEno());
		}
	}
	
	@Test
	public void testAddTime() throws Exception {
		mockMvc.perform(post("/add")
				.param("email", "aa@aa.com")
				.param("password", "aa")
				.param("body", "aa")
				)
			.andExpect(status().is(302));
		List<BoardEntity> list = boardDao.selectList();
		try {
			assertNotNull(list.get(0).getWriteTime());
		} finally {
			boardDao.delete(list.get(0).getEno());
		}
	}
	
	@Test
	public void testAlignment() throws Exception {
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
	public void testEdit() throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail("aa@aa.com").setPassword("11").setBody("aa");
		
		int no = boardDao.insert(be);
		
		try {
			mockMvc.perform(post("/edit")
						.param("eno", Integer.toString(no))
						.param("password", "11")
						.param("body", "aabb")
					).andExpect(status().is(302));
			
			
			List<BoardEntity> list = boardDao.selectList();
			assertThat(list.get(0).getBody(), is("aabb"));
			
		} finally {
			boardDao.delete(no);
		}
	}
	
	@Test
	public void testEditTime() throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail("aa@aa.com").setPassword("11").setBody("aa");
		
		int no = boardDao.insert(be);
		
		be = boardDao.selectOne(no);
		
		Thread.sleep(10);
		try {
			mockMvc.perform(post("/edit")
						.param("eno", Integer.toString(no))
						.param("password", "11")
						.param("body", "aabb")
					).andExpect(status().is(302));
			
			
			List<BoardEntity> list = boardDao.selectList();
			assertNotNull(list.get(0).getEditTime());
			assertNotEquals(list.get(0).getEditTime(), be.getEditTime());
			
		} finally {
			boardDao.delete(no);
		}
	}
	
	@Test
	public void testAddWrongEmail() throws Exception {
		mockMvc.perform(post("/add")
					.param("email", "aa@.com")
					.param("password", "11")
					.param("body", "aa")
				).andExpect(status().isOk())
				.andExpect(view().name("emailFormatError"));
		
		List<BoardEntity> list = boardDao.selectList();
		boardDao.delete(list.get(0).getEno());
	}
}
