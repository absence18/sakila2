package com.gd.sakila2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.CategoryMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CategoryService {
	
@Autowired CategoryMapper categoryMapper;

	public List<Map<String, Object>> getCategoryList() {
		
		return categoryMapper.selectCategory();
	}

}
