package com.nhnent.board;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String boardHome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "board";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public void addBoardEntity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/board/");
	}
}
