package com.gd.sakila2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.sakila2.mapper.CustomerMapper;
import com.gd.sakila2.vo.CustomerList;
import com.gd.sakila2.vo.PageParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CustomerService {
	
@Autowired CustomerMapper customerMapper;
	
	@GetMapping("/getCustomerList")
	public List<CustomerList> getCustomerList(Map<String, Object> map) {
		
		int currentPage = (int) map.get("currentPage");
		int rowPerPage = (int) map.get("rowPerPage");
		String searchWord = (String) map.get("searchWord");
		
		PageParam pageParam = new PageParam();
		pageParam.setBeginRow((currentPage - 1) * rowPerPage);
		pageParam.setRowPerPage(rowPerPage);
		log.debug("★★★★★★★ pageParam" + pageParam);
		
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("pageParam", pageParam);
		parmMap.put("searchWord", searchWord);
		log.debug("★★★★★★★ parmMap : " + parmMap);
		
		int totalPage = customerMapper.selectCustomerTotal(searchWord);
		int lastPage = currentPage;
		log.debug("★★★★★★★ totalPage" + totalPage);
		log.debug("★★★★★★★ currentPage" + currentPage);
		
		List<CustomerList> customerList = customerMapper.selectCustomerList(map);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("customerList", customerList);
		returnMap.put("lastPage", lastPage);
		
		return customerMapper.selectCustomerList(map);
	}

}
