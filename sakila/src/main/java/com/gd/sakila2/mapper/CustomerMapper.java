package com.gd.sakila2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.CustomerList;

@Mapper
public interface CustomerMapper {
	
	List<CustomerList> selectCustomerList(Map<String, Object> map);
	int selectCustomerTotal(Map<String, Object> map);
	List<Map<String, Object>> selectBlackCustomerList();
	
	List<Map<String, Object>> selectCustomerOne();

}
