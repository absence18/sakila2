package com.gd.sakila2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.BoardMapper;
import com.gd.sakila2.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BoardService {
	@Autowired BoardMapper boardMapper;
	
	public List<Board> getBoardList(){
		log.debug("BoardService의 getBoardList 실행...");
		return boardMapper.selectBoardList();
	}
	
}
