package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberDao;
import com.domain.AuthVO;
import com.domain.MemberVO;
import com.domain.MemberVO.MemberGrade;
import com.service.MemberService;


@WebServlet("/main/*")
public class MainController extends HttpServlet {

    private MemberService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
    	MemberDao dao = new MemberDao();
    	service = new MemberService(dao);
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
		
		final String PRE = "/WEB-INF/views/main/";
		final String SUR = ".jsp";
		
		String nextPage = null;
		RequestDispatcher rd = null;
		//메인으로가기
		if(pathInfo==null || pathInfo.equals("/")) {
			nextPage = "main";
		//로그인
		}else {
			System.out.println("찾을수 없는 메인 페이지");
			
		}
		rd = request.getRequestDispatcher(PRE+nextPage+SUR);
		rd.forward(request, response);
	
	}
}
