package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class LoginController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		
		if(vo != null) {
			session.setAttribute("mvo", vo);
			return "redirect:index.jsp";
		}else
			return "redirect:login-fail.jsp";
	}

}
