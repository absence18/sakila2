package com.gd.sakila2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffListMapper {
	
	public List<Map<String, Object>> selectStaffList();

}
