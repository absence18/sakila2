package com.gd.sakila2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gd.sakila2.service.CommentService;

@Controller
@RequestMapping("/admin")
public class CommentController {
@Autowired CommentService commentService;

}
