package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class RegisterCarController {
	protected void registerCar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String carInfo = request.getParameter("carInfo");
		MockDAO.getInstance().register(carInfo);
		response.sendRedirect("registercar-result.jsp");
	}
}
