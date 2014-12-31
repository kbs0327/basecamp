package com.nhnent.board.dao;

import java.util.List;

import com.nhnent.board.vo.BoardEntity;

public interface BoardDao {
	List<BoardEntity> selectList() throws Exception;
	void createTable() throws Exception;
	int insert(BoardEntity entity) throws Exception;//완료후 키값을 반환
	int delete(int no) throws Exception;
	BoardEntity selectOne(int no) throws Exception;
	int update(BoardEntity entity) throws Exception;
	BoardEntity selectPassword(int no) throws Exception;
}
