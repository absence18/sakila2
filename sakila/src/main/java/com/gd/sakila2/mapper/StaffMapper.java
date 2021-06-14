package com.gd.sakila2.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.Staff;

@Mapper
public interface StaffMapper {
	
	// staff list
	Staff selectStaffByLogin(Staff staff);

}
