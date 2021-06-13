package com.gd.sakila2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.CommentMapper;

@Service
@Transactional
public class CommentService {
@Autowired CommentMapper commentMapper;

}
