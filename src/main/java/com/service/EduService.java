package com.service;


import java.util.List;

import com.dao.EduDao;
import com.domain.Category;
import com.domain.MemberVO;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class EduService {

	private EduDao dao;
	//카테고리 리스트
//	public List<Category> subList() {
//		return dao.subList();
//		
//	}
	//멤버 번호받기
	public int getMno(int mno) {
		return dao.getMno(mno);
		
	}


	public void addResult(Category vo) {
		dao.addResult(vo);
		
	}
	public List<MemberVO> testResult(int mno) {
		return dao.testResult(mno);
		
	}
	



	











}
