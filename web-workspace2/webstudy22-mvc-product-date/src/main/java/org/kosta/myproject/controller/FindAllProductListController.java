package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.ProductDAO;
import org.kosta.myproject.model.ProductVO;

public class FindAllProductListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<ProductVO> list = ProductDAO.getInstance().findAllProductList();
		request.setAttribute("list", list);
		
		return "product-list.jsp";
	}

}
