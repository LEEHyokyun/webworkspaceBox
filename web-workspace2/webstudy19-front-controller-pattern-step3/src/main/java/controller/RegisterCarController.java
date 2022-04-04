package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class RegisterCarController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String carInfo = request.getParameter("carInfo");
		MockDAO.getInstance().register(carInfo);
		
		return "redirect:registercar-result.jsp";
	}
	
}
