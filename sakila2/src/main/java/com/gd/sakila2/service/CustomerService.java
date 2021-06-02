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
	
	//고객 리스트 출력
	public List<CustomerList> getCustomerList(Map<String,Object> map){
		return customerMapper.selectCustomerList(map);
	}

	// 블랙 리스트 출력
	public List<Map<String, Object>> getBlackCustomerList(){
		return customerMapper.selectBlackCustomerList();
	}

	// 고객 리스트 페이징을 위한 total 수
	public int getCustomerListTotal(Map<String,Object> map){
		return customerMapper.selectCustomerTotal(map);
	}

}
