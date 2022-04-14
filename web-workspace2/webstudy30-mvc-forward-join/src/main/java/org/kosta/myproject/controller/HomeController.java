package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.EmployeeDAO;

public class HomeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int totalEmpCount = EmployeeDAO.getInstance().findEmpTotalCount();
		request.setAttribute("totalEmpCount", totalEmpCount);
		
		return "home.jsp";
	}

}
