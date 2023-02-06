package com.controller;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	
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
		final String PRE = "/WEB-INF/views/member/";
		final String SUR = ".jsp";
		
		
		String nextPage = null;
		RequestDispatcher rd = null;
		if(pathInfo.equals("/memberInfo")) {
			List<MemberVO> memberList = service.memberList();
			request.setAttribute("memberInfo", memberList);
			nextPage="memberInfo";
			
		}else if(pathInfo.equals("/loginForm")) {
			nextPage="loginForm";
		}
		else if(pathInfo.equals("/login")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd"); // 암호화후 변경
			MemberVO vo = MemberVO.builder()
					.id(id).pwd(pwd).build();

			if(service.loginService(vo)) {
				HttpSession session = request.getSession();
				
				MemberGrade grade = service.getMembergrade(vo.getId());
				AuthVO authVO = new AuthVO();
				authVO.setId(vo.getId());
				authVO.setGrade(grade);
				session.setAttribute("auth", authVO);
				String userUri = (String) session.getAttribute("userUri");
				
				if(userUri!=null) {
					session.removeAttribute("userUri");
					response.sendRedirect(userUri);
					return;
				}
				response.sendRedirect(contextPath+"/main");
				return;
			}else {
				System.out.println("MemberController.login : 아이디 또는 비밀번호 불일치");
				return;
			}
		//로그아웃
		}else if(pathInfo.equals("/logout")) {
			HttpSession session = request.getSession(false);
			session.removeAttribute("auth");
			response.sendRedirect(contextPath+"/main");
			return;
		//회원가입폼
		}else if(pathInfo.equals("/joinForm")) {
			nextPage = "joinForm";
		//회원가입 처리
		}else if(pathInfo.equals("/join")) {

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String personNo = request.getParameter("personNo");
			String militaryNo = request.getParameter("militaryNo");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			String birth = request.getParameter("birth");

			MemberVO vo = MemberVO.builder()
					.id(id).pwd(pwd).name(name).personNo(personNo)
					.militaryNo(militaryNo).addr(addr).email(email)
					.birth(birth).build();
			service.memberJoin(vo);
			response.sendRedirect(contextPath+"/main");
			return;
			
			}else {
			System.out.println("member : 잘못된 페이지 ");
		}
		
		
		rd = request.getRequestDispatcher(PRE+nextPage+SUR);
		rd.forward(request, response);
	}
}
