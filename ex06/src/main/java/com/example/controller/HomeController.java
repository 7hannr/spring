package com.example.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("pageName","/main.html");
		return "/home.html";
	}
	
	@GetMapping("/display")// /display?file=/upload/photo/a01.png
	public ResponseEntity<Resource> display(@RequestParam("file") String file) {
	    Resource resource = new FileSystemResource("c:" + file);
	    if(!resource.exists()) return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
	    HttpHeaders header = new HttpHeaders();
	    try{
	        Path filePath = Paths.get("c:" + file);
	        header.add("Content-type", Files.probeContentType(filePath));
	    }catch(Exception e) {
	        System.out.println("오류:" + e.toString());
	    }
	    return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
}