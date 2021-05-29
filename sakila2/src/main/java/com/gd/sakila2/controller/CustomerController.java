package com.gd.sakila2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.sakila2.service.CustomerService;

@Controller
public class CustomerController {
	
@Autowired CustomerService customerService;

	@GetMapping("/getCustomerList")
	public String getCustomerList(Model model) {
		
		List<Map<String, Object>> customerList = customerService.getCustomerList();
		
		model.addAttribute("customerList", customerList);
		
		return "getCustomerList";
	}

}
