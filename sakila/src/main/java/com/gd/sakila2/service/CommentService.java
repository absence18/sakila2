package com.gd.sakila2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.CommentMapper;
import com.gd.sakila2.vo.Comment;

@Service
@Transactional
public class CommentService {
@Autowired CommentMapper commentMapper;

	public int addComment(Comment comment) {
		
		
		return commentMapper.insertComment(comment);
	}

}
