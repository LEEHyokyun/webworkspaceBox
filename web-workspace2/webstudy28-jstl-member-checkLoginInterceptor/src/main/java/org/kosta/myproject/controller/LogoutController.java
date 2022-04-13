package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST") == false)
			throw new ServletException("허용되지 않은 접근입니다.");
		/*
		 * throw 할 경우 아래의 구문은 실행되지 않는다.
		 */
		
		//Session true/false는 중복의 개념으로 이해
		HttpSession session = request.getSession(false);
		
		if(session != null)
			session.invalidate();
		
		return "redirect:index.jsp";
	}

}
