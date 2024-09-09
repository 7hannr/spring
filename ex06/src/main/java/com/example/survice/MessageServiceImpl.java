package com.example.survice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.*;
import com.example.domain.*;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	MessageDAO dao;
	
	@Autowired
	UserDAO udao;
	
	@Transactional
	@Override
	public void insert(MessageVO vo) {
		dao.insert(vo);
		udao.updatePoint(vo.getSender(), 10);
	}

	@Transactional
	@Override
	public MessageVO readReceive(int mid) {
		MessageVO vo=dao.readReceive(mid);
		if(vo.getReadDate()==null){
			udao.updatePoint(vo.getReceiver(), 5);
			dao.updateReadDate(mid);
		}
		return vo;
	}
		
}
