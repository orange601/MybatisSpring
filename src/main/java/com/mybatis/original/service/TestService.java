package com.mybatis.original.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.common.CommonDAO;

@Service
public class TestService {
	@Autowired
	CommonDAO dao;
	
	//@Override
	public void selectMenuList() {
		Map<String, String> sd = new HashMap<>();
		List<HashMap<String, String>> result = dao.selectList("MGR0001.selectMenuList");
		System.out.println(result.get(0));
		System.out.println(result.get(0).get("USER_ID"));
	}

}
