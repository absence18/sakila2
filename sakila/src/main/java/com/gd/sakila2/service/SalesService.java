package com.gd.sakila2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.SalesMapper;
import com.gd.sakila2.vo.PageParam;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SalesService {
	
	@Autowired SalesMapper salesMapper;
	
	// 월별 매출 목록
	public Map<String, Object> getMonthlySalesList(PageParam pageParam) {
		
		Map<String, Object> returnMap = new HashMap<>();
		
		List<Map<String, Object>> list = salesMapper.selectMonthlySalesList(pageParam);
		String searchWord = pageParam.getSearchWord();
		log.debug(searchWord);
		int total = salesMapper.selectTotalSales(searchWord);
		log.debug("★★★★★ total : " + total);
		
		returnMap.put("list", list);
		returnMap.put("total", total);
		
		return returnMap;
	}

}
