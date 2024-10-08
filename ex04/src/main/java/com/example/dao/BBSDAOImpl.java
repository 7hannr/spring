package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.*;

@Repository
public class BBSDAOImpl implements BBSDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.BBSMapper";
	
	@Override
	public List<HashMap<String, Object>> list(QueryVO vo) {
		return session.selectList(namespace + ".list",vo);
	}

	@Override
	public int total(QueryVO vo) {
		return session.selectOne(namespace + ".total" ,vo);
	}

	@Override
	public BBSVO read(int bid) {
		return session.selectOne(namespace+".read",bid);
	}

	@Override
	public void delete(int bid) {
		session.delete(namespace+".delete",bid);
		
	}

	@Override
	public void update(BBSVO vo) {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void insert(BBSVO vo) {
		session.insert(namespace+".insert",vo);
		
	}

}
