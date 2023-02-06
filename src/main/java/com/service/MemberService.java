package com.service;

import java.util.List;

import com.dao.MemberDao;
import com.domain.Category;
import com.domain.MemberVO;
import com.domain.MemberVO.MemberGrade;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class MemberService {

	private MemberDao dao;

	public void memberJoin(MemberVO vo) {
		dao.insertMember(vo);
		
	}

	public boolean loginService(MemberVO vo) {
		return dao.loginService(vo);
		
	}

	public MemberGrade getMembergrade(String id) {
		return dao.findMemberGradeById(id);
	}
	//회원정보보기
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	
		
	


	

}
