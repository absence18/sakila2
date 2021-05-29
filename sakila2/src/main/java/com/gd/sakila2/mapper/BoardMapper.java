package com.gd.sakila2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.sakila2.vo.Board;
import com.gd.sakila2.vo.PageParam;

@Mapper
public interface BoardMapper {
	
	int selectBoardTotal(String searchWord);
	List<Board> selectBoardList(PageParam pageParam); // <-- parameterType

}
