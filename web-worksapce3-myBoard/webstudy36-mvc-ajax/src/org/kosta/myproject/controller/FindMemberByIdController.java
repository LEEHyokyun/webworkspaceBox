package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class FindMemberByIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		MemberVO vo = MemberDAO.getInstance().findMemberById(id);
		if(vo==null) {
			JSONObject json = new JSONObject();
			json.put("fail", "true");
			json.put("message", "회원정보가 존재하지 않습니다.");
			request.setAttribute("responsebody", json);
		}else {
			JSONObject json = new JSONObject(vo);
			request.setAttribute("responsebody", json);
		}
		
		return "AjaxView"; //ajax 방식으로 응답
	}

}
