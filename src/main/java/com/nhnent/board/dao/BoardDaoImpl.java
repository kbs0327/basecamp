package com.nhnent.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nhnent.board.vo.BoardEntity;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
	
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<BoardEntity> selectList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectList("com.nhnent.board.dao.BoardDao.selectList");
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public BoardEntity selectOne(int no) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne("com.nhnent.board.dao.BoardDao.selectOne", no);
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public BoardEntity selectPassword(int no) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne("com.nhnent.board.dao.BoardDao.selectPassword", no);
		} finally {
			sqlSession.close();
		}
	}
	
	//완료후 키 값을 반환
	@Override
	public int insert(BoardEntity entity) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int count = sqlSession.insert("com.nhnent.board.dao.BoardDao.insert", entity);
			sqlSession.commit();
			if(count == 1) {
				return entity.getEno();
			}
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	@Override
	public int update(BoardEntity entity) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int count = sqlSession.update("com.nhnent.board.dao.BoardDao.update", entity);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public int delete(int no) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int count = sqlSession.delete("com.nhnent.board.dao.BoardDao.delete", no);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	
}
