package com.mybatis.original.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.original.service.TestService;

@Controller
public class IndexController {
	
	@Autowired
	TestService service;
	
	@RequestMapping(value="/")
	@ResponseBody
	public void index() {
		service.selectMenuList();
	}

}
