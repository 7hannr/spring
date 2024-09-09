package com.example.survice;

import com.example.domain.*;

public interface MessageService {
	public void insert(MessageVO vo);
	public MessageVO readReceive(int mid);
	
}
