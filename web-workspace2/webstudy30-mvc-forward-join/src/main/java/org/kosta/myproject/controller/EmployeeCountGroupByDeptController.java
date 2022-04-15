package org.kosta.myproject.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.EmployeeDAO;

public class EmployeeCountGroupByDeptController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<HashMap<String, String>> list = EmployeeDAO.getInstance().findEmpCountGroupByDept();
		request.setAttribute("list", list);
		
		return "employee-count-dept.jsp";
	}

}
