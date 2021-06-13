package com.gd.sakila2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.sakila2.service.CustomerService;
import com.gd.sakila2.vo.CustomerList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	// 고객 추가 //
	// 폼
	@GetMapping("/addCustomer")
	public String addCustomer() {
		return "addCustomer";
	}

	// 액션
	@PostMapping("/addCustomer")
	public String addCustomer(Model model,
			@RequestParam(value = "storeId", required = false) Integer storeId,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "addressId", required = false) Integer addressId,
			@RequestParam(value = "active", required = false) Integer active) {
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@CustomerController에서 addCustomer -> storeId: " + storeId);
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@CustomerController에서 addCustomer -> firstName: " + firstName);
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@CustomerController에서 addCustomer -> lastName: " + lastName);
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@CustomerController에서 addCustomer -> email: " + email);
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@CustomerController에서 addCustomer -> addressId: " + addressId);
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@CustomerController에서 addCustomer -> active: " + active);

		Map<String, Object> map = new HashMap<>();
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@CustomerController에서 addCustomer -> map: " + map);
		map.put("storeId", storeId);
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		map.put("email", email);
		map.put("addressId", addressId);
		map.put("active", active);

		int addCustomer = customerService.addCustomer(map);
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@CustomerController에서 addCustomer -> addCustomer: " + addCustomer);

		model.addAttribute("map", map);
		model.addAttribute("storeId", storeId);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("email", email);
		model.addAttribute("addressId", addressId);
		model.addAttribute("active", active);

		return "redirect:/getCustomerList";
	}
	
	// 고객 상세보기
	@GetMapping("/getCustomerOne")
	public String getCustomerOne(Model model, @RequestParam(value = "ID", required = false) Integer ID) {
		log.debug("CustomerController에서 getCustomerOne -> ID: " + ID);

		Map<String, Object> map = customerService.getCustomerOne(ID);
		log.debug("CustomerController에서 getCustomerOne -> map: " + map);

		model.addAttribute("map", map);
		model.addAttribute("ID", ID);

		return "getCustomerOne";
	}

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
