package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;

public class CheckIdController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPath = null;
		String id = request.getParameter("id");
		
		boolean result = MemberDAO.getInstance().checkId(id);
		//true -> 존재 false -> 존재하지않음
		/*
		 * 중복확인을 통해 id check시 get method를 통해 넘겨진다.
		 */
		if(result)
			viewPath = "checkid-fail.jsp";
		else
			viewPath = "checkid-ok.jsp";
		
		return viewPath;
	}
	
}
