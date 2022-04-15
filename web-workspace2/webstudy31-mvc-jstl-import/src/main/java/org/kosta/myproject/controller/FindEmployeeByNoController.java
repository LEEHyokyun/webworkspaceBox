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
		
		if(evo == null)
			return "find-employee-fail.jsp"; //단독 view
		else {
			request.setAttribute("evo", evo);
			request.setAttribute("url", "emp/employee-detail.jsp");
			return "layout.jsp";
		}
	}

}
