package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class UpdateMemberController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  
		/* 
		 * session.getAttribute("mvo") == null) return "redirect:index.jsp";
		 */
		/*
		 * 해당 공통 정책은 일괄 처리하므로 삭제
		 */
		if(request.getMethod().equals("POST")==false)
			throw new ServletException("허용되지 않는 요청입니다.");
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		
		
		/*
		 * MemberVO vo = (MemberVO) session.getAttribute("mvo"); String regdate =
		 * vo.getRegdate();
		 * 
		 * MemberDAO.getInstance().update(new MemberVO(id, password, name, address,
		 * birthday, regdate)); MemberVO updatedvo = new MemberVO(id, password, name,
		 * address, birthday, regdate); session.setAttribute("mvo", updatedvo);
		 */
		
		MemberVO vo = new MemberVO(id, password, name, address, birthday, null);
		//regdate가 null로 선언되어도, 내부적으로 sysdate가 삽입되어 문제없이 DB update.
		MemberDAO.getInstance().update(vo);
		HttpSession session = request.getSession(false);
		session.setAttribute("mvo", vo);
		
		return "redirect:update-result.jsp";
	}

}
