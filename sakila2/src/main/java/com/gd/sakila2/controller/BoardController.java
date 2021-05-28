package com.gd.sakila2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String getBoardList(Model model) {
		List<Map<String, Object>> categoryList = categoryService.getCategoryList();
		List<Board> boardList = boardService.getBoardList();
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("boardList", boardList);
		
		return "getBoardList";
	}
	
}
