package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class FindCarByNoController {
	protected void findCarByNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String carNo = request.getParameter("carNo");
		
		String car = MockDAO.getInstance().findCarByNo(carNo);
		if(car == null)
			request.getRequestDispatcher("findcar-fail.jsp").forward(request, response);
		else {
			request.setAttribute("car", car);
			request.getRequestDispatcher("findcar-ok.jsp").forward(request, response);
		}
	}
}
