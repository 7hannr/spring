package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.AttachVO;
import com.example.domain.GoodsVO;
import com.example.domain.QueryVO;

@Repository
public class GoodsDAOImpl implements GoodsDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.GoodsMapper";
	
	@Override
	public void insert(GoodsVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public GoodsVO read(String gid) {
		return session.selectOne(namespace + ".read", gid);
	}

	@Override
	public int total() {
		return session.selectOne(namespace + ".total");
	}

	@Override
	public List<HashMap<String, Object>> list(QueryVO vo) {
		return session.selectList(namespace + ".list", vo);
	}

	@Override
	public void delete(String gid) {
		session.delete(namespace + ".delete", gid);
	}

	@Override
	public void update(GoodsVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void updateImage(GoodsVO vo) {
		session.update(namespace + ".updateImage", vo);
	}

	@Override
	public void updateContents(GoodsVO vo) {
		session.update(namespace + ".updateContents", vo);
	}

	@Override
	public void insertAttach(AttachVO vo) {
		session.insert(namespace + ".insertAttach", vo);
	}

	@Override
	public List<AttachVO> listAttach(String gid) {
		return session.selectList(namespace + ".listAttach", gid);
	}

	@Override
	public void deleteAttach(int aid) {
		session.delete(namespace + ".deleteAttach", aid);
	}

	@Override
	public void insertRelated(String gid, String rid) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("gid", gid);
		map.put("rid", rid);
		session.insert(namespace + ".insertRelated", map);
	}

	@Override
	public int countRelated(String gid, String rid) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("gid", gid);
		map.put("rid", rid);
		return session.selectOne(namespace + ".countRelated", map);
	}

	@Override
	public List<HashMap<String, Object>> listRealated(String gid) {
		return session.selectList(namespace + ".listRelated", gid);
	}

	@Override
	public void deleteRelated(String gid, String rid) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("gid", gid);
		map.put("rid", rid);
		session.delete(namespace + ".deleteRelated", map);
	}
}