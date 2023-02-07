package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			List<Category> subList = service.subList();
			request.setAttribute("subList", subList);
			
			String paramMno = request.getParameter("mno");
			System.out.println(Integer.parseInt(paramMno));
			nextPage="memberEduForm";
			
		//점수 =입력받기
		//게시글 수정이랑 비슷
		//입력받은 scoreRank를 저장
		//결과 처리
		}else if(pathInfo.equals("/rankResult")) {
			String paramMno = request.getParameter("mno");
			System.out.println(Integer.parseInt(paramMno));
			
				Category Cate = Category.builder()
						.mno(0)
						.scoreRank(request.getParameter("scoreRank"))
						.build(); 
			System.out.println(Cate);
				
				
				
			response.sendRedirect(contextPath+"/edu/rankResult");
			return;
		}
		
		else {
			System.out.println("edu : 찾을수 없는 페이지");
		}
		rd = request.getRequestDispatcher(PRE+nextPage+SUR);
		rd.forward(request, response);

	}
}