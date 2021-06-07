package com.gd.sakila2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.PageParam;

@Mapper
public interface SalesMapper {
	
	List<Map<String, Object>> selectMonthlySalesList(PageParam pageParam);
	int selectTotalSales(String searchWord);

}
