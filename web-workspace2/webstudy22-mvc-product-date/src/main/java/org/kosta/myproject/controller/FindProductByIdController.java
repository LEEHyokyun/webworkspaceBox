package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.ProductDAO;
import org.kosta.myproject.model.ProductVO;

public class FindProductByIdController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPath = null;
		String productId = request.getParameter("productId");
		ProductVO vo = ProductDAO.getInstance().findProductById(productId);
		//vo에서 getInstance 시점에서 이미 객체가 생성되어 null이 될 수 없다.
		System.out.println(vo);
		if(vo != null) {
			request.setAttribute("vo", vo);
			viewPath = "findbyid-ok.jsp";
		}else {
			viewPath = "findbyid-fail.jsp";
		}
		
		System.out.println(viewPath);
		
		return viewPath;
	}
	
	
}
