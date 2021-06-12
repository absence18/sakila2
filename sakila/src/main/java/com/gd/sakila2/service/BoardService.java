package com.gd.sakila2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.BoardMapper;
import com.gd.sakila2.vo.Board;
import com.gd.sakila2.vo.Page;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BoardService {
	@Autowired BoardMapper boardMapper;
	
	// board 삭제
	public int removeBoard(Board board) {
		
		return boardMapper.deleteBoard(board);
	}
	
	// board 추가
	public int addBoard(Board board) {
		
		return boardMapper.insertBoard(board);
	}
	
	// board 상세보기
	public Map<String, Object> getBoardOne(int boardId) {
		
		return boardMapper.selectBoardOne(boardId);
	}
	
	// board 리스트
	public Map<String, Object> getBoardList(int currentPage, int rowPerPage, String searchWord){ // <-- controller에서 받아오는 parameter
		log.debug("BoardService의 getBoardList 실행...");
		
		int boardTotal = boardMapper.selectBoardTotal(searchWord);
		
		int lastPage = boardTotal / rowPerPage;
		if(boardTotal % rowPerPage != 0) {
			lastPage++;
		}
		// int lastPage = (int)(Math.ceil((double)boardTotal / rowPerPage));
		
		int beginRow = (currentPage - 1) * rowPerPage;
		
		Page pageParam = new Page();
		
		pageParam.setBeginRow(beginRow);
		pageParam.setRowPerPage(rowPerPage);
		pageParam.setSearchWord(searchWord);
		
		List<Board> boardList = boardMapper.selectBoardList(pageParam);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("lastPage", lastPage);
		map.put("boardList", boardList);
		
		return map;
	}
	
}
