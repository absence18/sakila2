package com.gd.sakila2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.sakila2.service.CommentService;
import com.gd.sakila2.vo.Comment;

@Controller
@RequestMapping("/admin")
public class CommentController {
@Autowired CommentService commentService;

	@GetMapping("/addComment")
	public String addCommnet(Comment comment, @RequestParam(value="boardId", required=true)int boardId) {
		
		return "redirect:/admin/getBoardOne?boardId=" + boardId;
	}
	
}
