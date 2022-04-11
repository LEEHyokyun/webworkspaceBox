package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class FindMemberByIdController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		MemberVO vo = (MemberVO) MemberDAO.getInstance().findMemberById(id);
		System.out.println("VO from Controller is: "+vo);
		if(vo != null) {
			request.setAttribute("vo", vo);
			return "findbyid-ok.jsp";
		}
		else
			return "findbyid-fail.jsp";
		
	}

}
