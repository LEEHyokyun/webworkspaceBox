package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.Pagination;
import org.kosta.myproject.model.PostVO;

public class ListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");
		Pagination pagination = null;
		if(pageNo == null)  //pagoNo가 없는 경우 = 최초 접속하였을 경우
			pagination = new Pagination(BoardDAO.getInstance().getTotalPostCount());
		else //다른 페이지로 넘어갈 경우, totalCount와 nowPage가 전달된다.
			pagination = new Pagination(BoardDAO.getInstance().getTotalPostCount(), Integer.parseInt(pageNo));
		
		//list.jsp에서 페이지 처리를 하기 위해 Pagination 객체를 공유
		request.setAttribute("pagination", pagination);
		
		ArrayList<PostVO> list = BoardDAO.getInstance().findPostList(pagination);
		//System.out.println(list.get(1));
		
		request.setAttribute("list", list);
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}
	
}
