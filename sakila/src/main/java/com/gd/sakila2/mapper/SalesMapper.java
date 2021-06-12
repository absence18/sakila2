package com.gd.sakila2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.Page;

@Mapper
public interface SalesMapper {
	
	List<Map<String, Object>> selectMonthlySalesList(Page pageParam);
	int selectTotalSales(String searchWord);

}
