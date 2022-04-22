package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if(session != null)
			session.invalidate();
		return "redirect:ListController.do";
		/*
		 * 기본적으로 ListController로 redirect해준다면 최초 페이지 화면 보여주기 가능
		 */
	}

}
