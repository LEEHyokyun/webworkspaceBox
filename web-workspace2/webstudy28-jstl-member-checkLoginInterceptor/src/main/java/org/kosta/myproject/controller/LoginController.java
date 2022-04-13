package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class LoginController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * http request method를 확인하여, 부합하지 않는 method라면 요청을 거절할 수 있다
		 * url을 통한 로그인, 로그아웃 등 방지
		 * post 방식일때만 로그인 허용, url접근은 불허(*url로 접근한다면 그것은 get method).
		 * post 방식이 아니라면 Servlet exception 발생
		 */
		if(request.getMethod().equals("POST") == false) 
			throw new ServletException("로그인 서비스는 POST 요청만 허용됩니다.");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		/*
		 * 기존 세션이 있다면 반환, 없다면 새로 생성(*없다면 새로 생성한다는 것이 중요)
		 * 아래의 경우 세션에 vo객체를 저장, 일단 새로 생성해야한다.
		 */
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		
		if(vo != null) {
			session.setAttribute("mvo", vo);
			return "redirect:index.jsp";
		}else
			return "redirect:login-fail.jsp";
		}
	
}
