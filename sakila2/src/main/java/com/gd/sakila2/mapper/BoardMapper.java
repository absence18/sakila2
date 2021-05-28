package com.gd.sakila2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.Board;

@Mapper
public interface BoardMapper {
	
	List<Board> selectBoardList();

}
