package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.EmployeeDAO;
import org.kosta.myproject.model.EmployeeVO;

public class EmployeeListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<EmployeeVO> list = EmployeeDAO.getInstance().findAllEmployeeList();
		request.setAttribute("list", list);
		request.setAttribute("url", "emp/employee-list.jsp");
		return "layout.jsp";
	}

}
