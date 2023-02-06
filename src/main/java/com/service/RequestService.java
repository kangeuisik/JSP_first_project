package com.service;

import java.util.List;

import com.dao.RequestDao;
import com.domain.RequestVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestService {
	
	private RequestDao dao;
	
	
	//휴가 요청 목록
	public List<RequestVO> resultList() {
		return dao.requestResultList();
	}
	//요청자중 승인대기자 목록
	public List<RequestVO> resultORList() {
		return dao.resultORList();
	}
	
	public int addRequest(RequestVO vo) {
		return dao.addRequest(vo);
		
	}
	//새 신청번호
	public int getRequestNo() {
		return dao.getNewBno();
	}

	
	//승인처리
	public void updateGo(RequestVO vo) {
		dao.updateGo(vo);
	}
	//거절 처리
	public void updateNo(RequestVO vo) {
		dao.updateNo(vo);
		
	}

//	//승인후 수정
//	public void updateResultOR(RequestVO vo) {
//		dao.updateResultOR(vo);
//		
//	}


}

