package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class FindMemberListByAddressController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * HttpSession session = request.getSession(); if(session == null ||
		 * session.getAttribute("mvo") == null) {
		 * System.out.println("로그인 후 이용가능한 서비스입니다."); return "redirect:index.jsp"; }
		 */
		/*
		 * 해당 공통정책은 일괄 처리하므로 삭제.
		 */
		
		String address = request.getParameter("address");
		
		ArrayList<MemberVO> list = MemberDAO.getInstance().findMemberListByAddress(address);
		request.setAttribute("list", list);
		
		return "findbyaddress-result.jsp";
	}
	
}
