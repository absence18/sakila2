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

	@Autowired
	CustomerService customerService;

	@GetMapping("/getCustomerList")
	public String getCustomerList(Model model,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "rowPerPage", defaultValue = "10") int rowPerPage,
			@RequestParam(value = "searchWord", required = false) String searchWord) {

		// 쿼리 파라미터 수집
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", (currentPage - 1) * rowPerPage);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);

		// 고객 정보 리스트
		List<CustomerList> customerList = customerService.getCustomerList(map);

		// 블랙 리스트
		List<Map<String, Object>> blackCustomerList = customerService.getBlackCustomerList();

		int lastPage = customerService.getCustomerListTotal(map);

		// 리스트 response
		model.addAttribute("customerList", customerList);
		model.addAttribute("blackCustomerList", blackCustomerList);

		// 일반 변수 response
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);

		return "getCustomerList";
	}

}