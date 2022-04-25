package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;

/**
 * Ajax 방식으로 id 중복확인 
 * @author hyokyun
 *
 */
public class CheckIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		boolean result = MemberDAO.getInstance().idcheck(id); 
		/*
		 * result = true -> 아이디 중복된다.
		 * result = false -> 아이디 중복되지 않는다.
		 */
		String checkResult = null;
		if(result)
			checkResult = "fail";
		else
			checkResult = "ok";
		
		request.setAttribute("responsebody", checkResult);
		return "AjaxView";
	}

}
