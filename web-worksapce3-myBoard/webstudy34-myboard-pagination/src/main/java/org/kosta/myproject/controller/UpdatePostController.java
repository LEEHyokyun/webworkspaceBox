package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class UpdatePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//System.out.println(title);
		
		PostVO pvo = new PostVO();
		//pvo는 새로운 객체이며 생성자를 통해 만들어지지 않았기 때문에 전달되는 인자가 null인지 default인지 등을 확인해야 한다.
		pvo.setNo(Integer.parseInt(no));
		pvo.setTitle(title);
		pvo.setContent(content);
		
		BoardDAO.getInstance().updatePost(pvo);
		
		return "redirect:ListController.do";
	}

}
