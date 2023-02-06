package com.service;

import java.util.List;

import com.dao.BoardDao;
import com.domain.BoardVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardService {
	
	private BoardDao dao;
//글목록
	public List<BoardVO> BoardList() {
		
		return dao.BoardList();
	}
//글상세
	public BoardVO detailBoard(int bno) {
		return dao.detailBoard(bno);
	}
//글쓰기
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}
	
	public void modBoard(BoardVO vo) {
		dao.modBoard(vo);
	}
	public void removeBoard(int bno) {
		dao.removeBoard(bno);
		
	}
	//공지사항
	public List<BoardVO> noticeList() {
		return dao.noticeList();
	}
	//병사 게시판
	public List<BoardVO> sergantList() {
		return dao.sergantList();
	}
	//가족게시판
	public List<BoardVO> parentsList() {
		return dao.parentsList();
	}
	//간부업무참고
	public List<BoardVO> adminList() {
		return dao.adminList();
	}
}
