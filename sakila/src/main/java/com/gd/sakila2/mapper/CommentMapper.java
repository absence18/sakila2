package com.gd.sakila2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.Comment;

@Mapper
public interface CommentMapper {
	
	// select commentList
	List<Comment> selectCommentList(int boardId);

}
