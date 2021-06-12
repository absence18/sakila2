package com.gd.sakila2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.Country;
import com.gd.sakila2.vo.Page;

@Mapper
public interface CountryMapper {
	List<Country> selectCountryList(Page pageParam);
	int selectCountryTotal();
}
