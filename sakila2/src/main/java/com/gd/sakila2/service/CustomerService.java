package com.gd.sakila2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.CustomerMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CustomerService {
	
@Autowired CustomerMapper customerMapper;

	public List<Map<String, Object>> getCustomerList() {
		
		return customerMapper.selectCustomerList();
	}

}
