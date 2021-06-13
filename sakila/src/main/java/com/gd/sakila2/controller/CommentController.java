package com.gd.sakila2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gd.sakila2.service.CommentService;

@Controller
public class CommentController {
@Autowired CommentService commentService;

}
