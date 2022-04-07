package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.ProductDAO;
import org.kosta.myproject.model.ProductVO;

public class RegisterProductController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String maker = request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));
		
		ProductDAO.getInstance().register(new ProductVO(name, maker, price));
		
		return "redirect:register-product-result.jsp";
	}

}
