package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.MemberVO;
import org.kosta.myproject.model.PostVO;

public class WritePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostVO pvo = new PostVO();
		pvo.setTitle(title);
		pvo.setContent(content);
		
		request.setAttribute("pvo", pvo);
		request.setAttribute("url", "board/write.jsp");
		
		return "layout.jsp";
	}

}
