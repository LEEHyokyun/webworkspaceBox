package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMemberFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 회원정보수정 역시 로그인 상태에서만 유효하다.
		/*
		 * HttpSession session = request.getSession(false);
		 * 
		 * if (session == null || session.getAttribute("mvo") == null) return
		 * "redirect:index.jsp";
		 */
		/*
		 * 공통 정책은 일괄 처리
		 */
		return "redirect:update-form.jsp";

	}

}
