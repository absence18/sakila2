package com.gd.sakila2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gd.sakila2.service.StaffListService;

@Controller
@RequestMapping("/admin")
public class StaffListController {
	
	@Autowired StaffListService staffListService;
	
	@GetMapping("/getStaffList")
	public String getStaffList() {
		
		
		
		return "getStaffList";
	}
	
	

}
