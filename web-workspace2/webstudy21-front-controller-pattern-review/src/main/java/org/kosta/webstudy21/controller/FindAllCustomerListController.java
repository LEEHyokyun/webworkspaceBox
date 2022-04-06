package org.kosta.webstudy21.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy21.model.MockDAO;

public class FindAllCustomerListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> list = MockDAO.getInstance().findAllCustomerList();
		
		request.setAttribute("customerList", list);
		return "find-list.jsp";
	}
	
}
