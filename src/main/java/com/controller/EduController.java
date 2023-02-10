package com.controller;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EduDao;
import com.dao.MemberDao;
import com.domain.Category;
import com.domain.MemberVO;

import com.service.EduService;
import com.service.MemberService;



@WebServlet("/edu/*")
public class EduController extends HttpServlet {

    private EduService service;
    private MemberService Mservice;
	

    @Override
    public void init(ServletConfig config) throws ServletException {
    	EduDao dao = new EduDao();
    	MemberDao Mdao = new MemberDao();
    	service = new EduService(dao);
    	Mservice = new MemberService(Mdao);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		
		final String PRE = "/WEB-INF/views/edu/";
		final String SUR = ".jsp";
		
		String nextPage = null;
		RequestDispatcher rd = null;
		//훈련평가 리스트
		if(pathInfo.equals("/memberEduList")) {
			List<MemberVO> memberList = Mservice.memberList();
			request.setAttribute("memberList", memberList);
			nextPage="memberEduList";
			
		//평가결과 입력창
		}else if(pathInfo.equals("/memberEduForm")) {
			String paramMno = request.getParameter("mno");
			int mno = Integer.parseInt(paramMno);
			int getMno = service.getMno(mno);
			request.setAttribute("mno", getMno);
			
			List<MemberVO> byMnoMember = service.byMnoMember(mno);
			request.setAttribute("list", byMnoMember);
			System.out.println(byMnoMember);
			nextPage="memberEduForm";
			
		//점수 =입력받기
		//게시글 수정이랑 비슷
		//입력받은 scoreRank를 저장
		//결과 처리
		}else if(pathInfo.equals("/rankResult")) {
			
			String paramMno = request.getParameter("mno");
			int mno = Integer.parseInt(paramMno);
			request.setAttribute("mno", mno);
			String[] subjects = request.getParameterValues("subject");
			String[] scoreRanks = request.getParameterValues("scoreRank");
			
			List<Category> categories = new ArrayList<Category>(); 
			for(int i=0;i<subjects.length;i++) {
				Category category = Category.builder()
						.mno(mno)
						.subject(subjects[i])
						.scoreRank(scoreRanks[i]).build();
				categories.add(category);
			}
			
			for(Category c : categories) {
				Category vo = Category.builder()
					.mno(c.getMno())
					.subject(c.getSubject())
					.scoreRank(c.getScoreRank())
					.build();
				service.addResult(vo);
 			}

			response.sendRedirect(contextPath+"/edu/memberEduList");
			return;
		}else if(pathInfo.equals("/result")) {

			String parameter = request.getParameter("mno");
			int mno = Integer.parseInt(parameter);
			System.out.println(mno);
			List<MemberVO> testResult = service.testResult(mno);

			request.setAttribute("testResult", testResult);
			
			nextPage="result";
		}
		
		else {
			System.out.println("edu : 찾을수 없는 페이지");
		}
		rd = request.getRequestDispatcher(PRE+nextPage+SUR);
		rd.forward(request, response);

	}
}