package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RequestDao;
import com.domain.RequestVO;
import com.service.RequestService;


@WebServlet("/requestboard/*")
public class RequestController extends HttpServlet {

    private RequestService service;

     @Override
    public void init(ServletConfig config) throws ServletException {
    	 RequestDao dao = new RequestDao();
    	 service = new RequestService(dao);
    
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
		final String PRE = "/WEB-INF/views/requestboard/";
		final String SUR = ".jsp";
		
		String nextPage = null;
		RequestDispatcher rd = null;
		//병사-휴가신청
		if(pathInfo.equals("/vacationResult")) {
			List<RequestVO> resultList = service.resultList();
			request.setAttribute("resultList", resultList);
			nextPage = "vacationResult";
		//병사-휴가신청하기
		}else if(pathInfo.equals("/requestForm")) {
			request.setAttribute("requestNo",service.getRequestNo() );
			nextPage="requestForm";
			
		//병사-휴가신청처리
		}else if(pathInfo.equals("/request")) {
			List<RequestVO> resultList = service.resultList();
			request.setAttribute("resultList", resultList);
			int newNo = service.getRequestNo();
			RequestVO vo = RequestVO.builder()
					.requestNo(newNo)
					.name(request.getParameter("name"))
					.militaryNo(request.getParameter("militaryNo"))
					.requestDate(request.getParameter("requestDate"))
					.reason(request.getParameter("reason"))
					.resultOR(request.getParameter("resultOR"))
					.build();
			 service.addRequest(vo); 
			
	
			response.sendRedirect(contextPath+"/requestboard/vacationResult");
			return;
		}else if(pathInfo.equals("/resultBoard")) {
			List<RequestVO> resultORList = service.resultORList();
			request.setAttribute("resultORList", resultORList);
			nextPage = "/resultBoard";
		//'승인대기'자만 리스트로 표현하고 조건에 맞게 update처리
		}else if(pathInfo.equals("/resultORList")) {
			List<RequestVO> resultORList = service.resultORList();
			request.setAttribute("resultORList", resultORList);
			String[] Goparam = request.getParameterValues("goResult_ck");
			String[] Noparam = request.getParameterValues("noResult_ck");
			//승인과 거절 하나로 묶어보고
			//else if x
			
			//승인했다면~
			System.out.println("승인 : ");
			if(Goparam.length>0) {
				for(String g : Goparam) {
					System.out.println(g);
					System.out.println(Goparam);
					int requestNo = Integer.parseInt(g);
					RequestVO vo = RequestVO.builder()
							.requestNo(requestNo)
							.build();
					service.updateGo(vo);
				}
			}else return;
			//거절했다면~
			 if(Noparam.length>0 ) { 
				for(String n : Noparam) {
					System.out.println("거절: ");
					System.out.println(n);
					System.out.println(Noparam);
					int requestNo = Integer.parseInt(n);
					RequestVO vo = RequestVO.builder()
							.requestNo(requestNo)
							.build();
					service.updateNo(vo);
				}
			}else return;
			
			response.sendRedirect(contextPath+"/requestboard/vacationResult");
			return;
		} else {
			System.out.println("Request : 찾을수 없는 페이지");
		}
		
		rd = request.getRequestDispatcher(PRE+nextPage+SUR);
		rd.forward(request, response);
	}
}
