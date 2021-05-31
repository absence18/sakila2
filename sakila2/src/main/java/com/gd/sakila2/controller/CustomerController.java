package com.gd.sakila2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.sakila2.service.CustomerService;
import com.gd.sakila2.vo.CustomerList;

@Controller
public class CustomerController {
	
@Autowired CustomerService customerService;

	@GetMapping("/getCustomerList")
	public String getCustomerList(Model model,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "rowPerPage", defaultValue = "10") int rowPerPage,
			@RequestParam(value = "searchWord", required = false) String searchWord) {
		
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("currentPage", currentPage);
		pageMap.put("rowPerPage", rowPerPage);
		pageMap.put("searchWord", searchWord);
		
		List<CustomerList> customerList = customerService.getCustomerList(pageMap);
		
		model.addAttribute("customerList", customerList);
		model.addAttribute("pageMap", pageMap);
		
		return "getCustomerList";
	}

}
