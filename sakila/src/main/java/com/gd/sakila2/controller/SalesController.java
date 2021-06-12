package com.gd.sakila2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.sakila2.service.SalesService;
import com.gd.sakila2.vo.Page;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SalesController {
	
	@Autowired SalesService salesService;
	
	@GetMapping("/getSalesList")
	public String getSalesList(Model model,
			@RequestParam(value="currentPage", defaultValue="1")int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="5")int rowPerPage,
			@RequestParam(value="searchWord", required=false)String searchWord) {
		log.debug("★★★★★ currentPage : " + currentPage);
		// getSalesList param(currentPage) : <-- 민성 debug 메세지 //
		log.debug("★★★★★ rowPerPage : " + rowPerPage);
		log.debug("★★★★★ searchWord : " + searchWord);
		
		int beginRow = (currentPage-1) * rowPerPage;
		
		Page pageParam = new Page();
		
		pageParam.setBeginRow(beginRow);
		pageParam.setRowPerPage(rowPerPage);
		pageParam.setSearchWord(searchWord);
		
		Map<String, Object> map = salesService.getMonthlySalesList(pageParam);
		
		int total = (int) map.get("total");
		
		log.debug("total :" + total);
		log.debug("map :" + map.toString()); // <-- 민성이는 toString으로 함
		
		int lastPage = total / rowPerPage;
		if ((total % rowPerPage) != 0) {
			lastPage++;
		}
		log.debug("★★★★★★★ lastPage :" + lastPage);
		
		model.addAttribute("getSalesList", map.get("list"));
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		
		return "getSalesList";
	}

}
