package com.gd.sakila2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.CustomerList;
import com.gd.sakila2.vo.PageParam;

@Mapper
public interface CustomerMapper {
	
	int selectCustomerTotal(String searchWord);
	List<CustomerList> selectCustomerList(Map<String, Object> map);
	List<Map<String, Object>> selectCustomerOne();

}
