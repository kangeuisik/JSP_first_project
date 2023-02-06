package com.service;

import java.util.List;

import com.dao.EduDao;
import com.domain.Category;
import com.domain.MemberVO;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class EduService {

	private EduDao dao;

	public List<Category> subList() {
		return dao.subList();
		
	}

	public void eduResultList(List<MemberVO> vo, Category cateList) {
		dao.eduResultList(vo,cateList);
		
	}
	











}
