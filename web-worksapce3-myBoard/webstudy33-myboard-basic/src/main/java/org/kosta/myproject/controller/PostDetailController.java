package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		//System.out.println(id);
		PostVO pvo = BoardDAO.getInstance().findPostByNo(no);
		//System.out.println(pvo);
		
		
		HttpSession session = request.getSession(false);
		ArrayList<String> myBoardList = (ArrayList<String>) session.getAttribute("myBoardList");
		System.out.println(myBoardList);
		
		if(myBoardList == null || !myBoardList.contains(no))  {
			myBoardList.add(no);
			BoardDAO.getInstance().updateHits(no);
		}
		
		request.setAttribute("pvo", pvo);
		request.setAttribute("url", "board/post-detail.jsp");
		return "layout.jsp";
	}

}
