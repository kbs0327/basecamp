package com.nhnent.board.dao;

import java.util.List;

import com.nhnent.board.vo.BoardEntity;

public interface BoardDao {
	List<BoardEntity> selectList() throws Exception;
	int insert(BoardEntity entity) throws Exception;
	int delete(String email) throws Exception;
	BoardEntity selectOne(String email) throws Exception;
	int update(BoardEntity entity) throws Exception;
	BoardEntity exist(String email, String password) throws Exception;
}
