package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dao.*;
import com.example.domain.*;
import com.example.survice.MessageService;

@RestController
@RequestMapping("/message")
public class MessageRestController {
	@Autowired
	MessageDAO dao;
	
	@Autowired
	MessageService service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody MessageVO vo) {
		service.insert(vo);
	}
	
	@GetMapping("/send/{mid}")
	public MessageVO readSend(@PathVariable("mid") int mid) {
		return dao.readSend(mid);
	}
	
	@GetMapping("/receive/{mid}")
	public MessageVO readReceive(@PathVariable("mid") int mid) {
		return service.readReceive(mid);
	}
	
	@GetMapping("/send.json/{sender}")
	public List<MessageVO> listSend(@PathVariable("sender") String sender){
		return dao.listSend(sender);
	}
	
	@GetMapping("/receive.json/{receiver}")
	public List<MessageVO> listReceiver(@PathVariable("receiver") String receiver){
		return dao.listReceive(receiver);
	}
	
	@PostMapping("/receive/delete/{mid}")
	public void deleteReceive(@PathVariable("mid") int mid) {
		dao.deleteReceive(mid);
	}
	
	@PostMapping("/send/delete/{mid}")
	public void deleteSend(@PathVariable("mid") int mid) {
		dao.deleteSend(mid);
	}
	
	@GetMapping("/delete/list/{uid}")
	public List<MessageVO> deleteList(@PathVariable("uid") String uid){
		return dao.listDelete(uid);
	}
	
	@PostMapping("/reset/delete/{mid}")
	public void resetDelete(@PathVariable("mid") int mid,@RequestParam("type")String type) {
		dao.resetDelete(mid,type);
	}
}