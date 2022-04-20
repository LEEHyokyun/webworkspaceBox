package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("no");
		//System.out.println(id);
		PostVO pvo = BoardDAO.getInstance().findPostByNo(id);
		//System.out.println(pvo);
		
		request.setAttribute("pvo", pvo);
		request.setAttribute("url", "board/post-detail.jsp");
		return "layout.jsp";
	}

}
