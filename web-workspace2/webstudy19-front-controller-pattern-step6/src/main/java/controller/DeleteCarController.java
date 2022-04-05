package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class DeleteCarController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String carNo = request.getParameter("carNo");
		
		MockDAO.getInstance().deleteCar(carNo);
		
		return "redirect:deletecar-result.jsp";
	}

}
