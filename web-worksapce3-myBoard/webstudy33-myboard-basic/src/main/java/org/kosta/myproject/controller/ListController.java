package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class ListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<PostVO> list = BoardDAO.getInstance().findPostList();
		//System.out.println(list.get(1));
		
		request.setAttribute("list", list);
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}
	
}
