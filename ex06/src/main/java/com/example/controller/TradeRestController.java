package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.domain.*;
import com.example.survice.TradeService;


@RestController

public class TradeRestController {
	@Autowired
	TradeService service;
	
	@PostMapping("/trade/insert")
	public void insert(@RequestBody TradeVO vo) {
		service.insert(vo);
	}
}
