package com.nhnent.board;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhnent.board.dao.BoardDao;
import com.nhnent.board.vo.BoardEntity;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String boardHome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "board";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public void addBoardEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEmail(request.getParameter("email")).setPassword(request.getParameter("password")).setBody(request.getParameter("body"));
		
		boardDao.insert(be);
		
		response.sendRedirect("/board/");
	}
}
