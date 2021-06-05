package com.gd.sakila2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.sakila2.service.BoardService;
import com.gd.sakila2.service.CategoryService;
import com.gd.sakila2.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
@Autowired BoardService boardService;
@Autowired CategoryService categoryService;

	@GetMapping("/getBoardList")
	// model은 뷰로 넘겨주기 위한 상자, requestParam 뷰에서 받아 오는 parameter
	public String getBoardList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage,
											@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
											@RequestParam(value="searchWord", required=false) String searchWord){
		
		log.debug("★★★★★★★ currentPage" + currentPage);
		log.debug("★★★★★★★ rowPerPage" + rowPerPage);
		log.debug("★★★★★★★ searchWord" + searchWord);
		
		List<Map<String, Object>> categoryList = categoryService.getCategoryList();
		
		Map<String, Object> map = boardService.getBoardList(currentPage, rowPerPage, searchWord);
		
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("boardList", map.get("boardList"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		
		return "getBoardList";
	}
	
}