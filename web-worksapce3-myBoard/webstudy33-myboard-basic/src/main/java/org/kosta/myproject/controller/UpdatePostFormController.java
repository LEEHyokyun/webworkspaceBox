package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class UpdatePostFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request post method 확인
		if (!request.getMethod().equals("POST")) {
			throw new ServletException(getClass().getName() + " POST 방식만 허용되는 요청입니다.");
		}

		String no = request.getParameter("no");
		PostVO pvo = BoardDAO.getInstance().findPostByNo(no);

		request.setAttribute("pvo", pvo);
		request.setAttribute("url", "board/update.jsp");

		return "layout.jsp";
	}

}
