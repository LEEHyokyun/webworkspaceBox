package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;

public class DeletePostController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//request post method 확인
		if(!request.getMethod().equals("POST")) {
			throw new ServletException(getClass().getName()+" POST 방식만 허용되는 요청입니다.");
		}
		String no = request.getParameter("no");
		BoardDAO.getInstance().deletePostByNo(no);
		
		return "redirect:ListController.do";
	}
	
}
