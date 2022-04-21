package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.MemberVO;
import org.kosta.myproject.model.PostVO;

public class WritePostFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//request post method 확인
		if(!request.getMethod().equals("POST")) {
			throw new ServletException(getClass().getName()+" POST 방식만 허용되는 요청입니다.");
		}
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession(false);
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		
		PostVO pvo = new PostVO(title, content, mvo);
		BoardDAO.getInstance().posting(pvo);
		
		/*
		 * 글쓰기 완료시 기존 list 화면으로 돌아가야 하므로, redirect
		 * request에 set할 value가 없으므로 forward 아님
		 */
		return "redirect:ListController.do";
	}

}
