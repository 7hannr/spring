package com.example.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dao.*;
import com.example.domain.*;
import com.example.survice.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyRestController {
	@Autowired
	ReplyDAO dao;
	
	@Autowired
	ReplyService service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody ReplyVO vo) {
		service.insert(vo);
	}
	
	@GetMapping("/list.json/{bid}")
	public HashMap<String,Object>list(QueryVO vo,@PathVariable("bid")int bid){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("total", dao.total(bid));
		map.put("documents", dao.list(bid, vo));
		return map;
	}
	
	@PostMapping("/delete/{rid}")
		public void delete(@PathVariable("rid")int rid) {
		service.delete(rid);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody ReplyVO vo) {
		dao.update(vo);
	}
}
