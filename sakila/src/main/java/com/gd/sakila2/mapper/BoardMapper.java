package com.gd.sakila2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.Board;
import com.gd.sakila2.vo.Page;

@Mapper
public interface BoardMapper {
	
	// Board One
	Map<String, Object> selectBoardOne(int boardId);
	// Board Total
	int selectBoardTotal(String searchWord);
	// Board List
	List<Board> selectBoardList(Page pageParam); // <-- parameterType

}
