package com.nhnent.board;

import java.io.PrintWriter;
import java.util.List;
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
	public String boardHome(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);

		
		List<BoardEntity> list = boardDao.selectList();
		
		model.addAttribute("entityList", list);

		return "board";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String addBoardEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardEntity be = new BoardEntity();
		if(!BoardEntity.checkEmail(request.getParameter("email"))) {
			return "emailFormatError";
		}
		be.setEmail(request.getParameter("email"))
			.setPassword(request.getParameter("password"))
			.setBody(request.getParameter("body"));
		
		boardDao.insert(be);
		
		response.sendRedirect("/board/");
		
		return null;//this is unreachable
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	public String editBoardEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEno(Integer.parseInt(request.getParameter("eno")));
		
		be = boardDao.selectPassword(Integer.parseInt(request.getParameter("eno")));
		if(be.checkPassword(request.getParameter("password"))) {
			be.setBody(request.getParameter("body"));
			boardDao.update(be);
			response.sendRedirect("/board/");
		}
		
		return "passwordError";
	}
	
	@RequestMapping(value = "/passwordConfirm", method=RequestMethod.POST)
	public void confirmPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardEntity be = new BoardEntity();
		be.setEno(Integer.parseInt(request.getParameter("eno")));
		
		be = boardDao.selectPassword(Integer.parseInt(request.getParameter("eno")));
		PrintWriter out = response.getWriter();
		
		if(be.checkPassword(request.getParameter("password"))) {
			out.print("true");
		} else {
			out.print("false");
		}
	}
}
