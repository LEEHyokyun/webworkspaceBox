package org.kosta.webstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy21.model.MockDAO;

public class FindCustomerController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = request.getParameter("customerId");
		String customerInfo = MockDAO.getInstance().findCustomer(customerId);
		
		if(customerInfo == null)
			return "find-fail.jsp";
		else {
			request.setAttribute("customer", customerInfo);
			return "find-ok.jsp";
		}

	}

}
