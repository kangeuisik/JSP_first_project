package com.service;

import java.util.List;

import com.dao.ReplyDao;
import com.domain.ReplyVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReplyService {
	
	private ReplyDao dao;
	
	
	
	public List<ReplyVO> list(int bno) {
		
		return dao.list(bno);
	}

	public void writer(ReplyVO vo) {
		dao.insert(vo);
		
	}

	public void removeReply(int bno) {
		dao.deleteReply(bno);
		
	}


	
}
