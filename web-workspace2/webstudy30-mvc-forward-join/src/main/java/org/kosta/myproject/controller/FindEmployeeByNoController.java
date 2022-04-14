package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.EmployeeDAO;
import org.kosta.myproject.model.EmployeeVO;

public class FindEmployeeByNoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String empno = request.getParameter("empno");
		
		EmployeeVO evo = EmployeeDAO.getInstance().findEmployeeByNo(empno);
		request.setAttribute("evo", evo);
		
		return "employee-detail.jsp";
	}

}
