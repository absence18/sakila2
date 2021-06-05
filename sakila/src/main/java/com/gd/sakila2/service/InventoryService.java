package com.gd.sakila2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.sakila2.mapper.InventoryMapper;

@Service
public class InventoryService {
	
	@Autowired InventoryMapper inventoryMapper;
	
	// inventory list
	public List<Map<String, Object>> getInventoryList(Map<String, Object> map) {
		return inventoryMapper.selectInventoryList(map);
	}

	// inventory paging
	public int getInventoryListTotal(Map<String, Object> map) {
		return inventoryMapper.selectInventoryListTotal(map);
	}

}
