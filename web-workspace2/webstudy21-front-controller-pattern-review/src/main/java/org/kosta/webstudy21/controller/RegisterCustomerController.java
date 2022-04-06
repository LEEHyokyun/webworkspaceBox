package org.kosta.webstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy21.model.MockDAO;

public class RegisterCustomerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerInfo = request.getParameter("customerInfo");
		MockDAO.getInstance().register(customerInfo);

		return "redirect:register-result.jsp";
	}

}
