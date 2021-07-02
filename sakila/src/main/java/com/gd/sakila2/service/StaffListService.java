package com.gd.sakila2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.StaffListMapper;

@Service
@Transactional
public class StaffListService {
	
	@Autowired StaffListMapper staffListMapper;
	
	public List<Map<String, Object>> getStaffList() {
		
		List<Map<String, Object>> staffList = staffListMapper.selectStaffList();
		
		return staffList;
	}

}
