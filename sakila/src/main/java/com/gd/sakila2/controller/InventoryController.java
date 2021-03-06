package com.gd.sakila2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.sakila2.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Controller
@RequestMapping("/admin")
public class InventoryController {
	
	@Autowired InventoryService inventoryService;
	
	@GetMapping("/getInventoryList")
	public String getInventoryList(Model model,
			@RequestParam(value="storeId", required = false)Integer storeId, // 매장별 출력을 위한 파라미터
			@RequestParam(value="currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "rowPerPage", defaultValue = "10") int rowPerPage,
			@RequestParam(value="searchWord", required = false)String searchWord) {
		
		log.debug("getInventoryList요청 파라미터값 storeId :" + storeId);
		log.debug("getInventoryList요청 파라미터값 currentPage :" + currentPage);
		log.debug("getInventoryList요청 파라미터값 rowPerPage :" + rowPerPage);
		log.debug("getInventoryList요청 파라미터값 searchWord :" + searchWord);
		
		if (searchWord != null && searchWord.equals("")) {
			searchWord = null;
		}

		if (storeId != null && storeId == 0) { // option value 0 처리
			storeId = null;
		}

		Map<String, Object> map = new HashMap<>();
		map.put("storeId", storeId);
		map.put("beginRow", (currentPage - 1) * rowPerPage);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);

		// 재고 리스트
		List<Map<String, Object>> inventoryList = inventoryService.getInventoryList(map);

		// 동적 쿼리에 따른 마지막 페이지 계산
		int inventoryTotal = inventoryService.getInventoryListTotal(map);
		int lastPage = (int) Math.ceil((double) inventoryTotal / rowPerPage);
		log.debug("getInventoryList응답 데이터 lastPage :" + lastPage);

		// 리스트 데이터
		model.addAttribute("inventoryList", inventoryList);

		// 단일 변수 데이터
		model.addAttribute("storeId", storeId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("searchWord", searchWord);

		return "/getInventoryList";
	}

}
