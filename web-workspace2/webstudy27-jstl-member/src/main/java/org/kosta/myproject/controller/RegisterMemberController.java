package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class RegisterMemberController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//POST method일 경우 필수 설정
		if(request.getMethod().equals("POST") == false)
			throw new ServletException("허용되지 않는 접근입니다.");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		
		//내부적으로 sysdate로 자동적으로 현재 날짜가 regdate에 기입, null로 초기화하여도 문제없다.
		MemberDAO.getInstance().register(new MemberVO(id, password, name, address, birthday, null));
		//execute가 종료되면 생성된 MemberVO는 gc, 즉 사라진다.
		return "redirect:register-result.jsp";
	}
	
}
