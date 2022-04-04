package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class FindCarByNoController implements Controller{
	//실질적인 처리 로맂ㄱ
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = null;
		String carNo = request.getParameter("carNo");
		
		String carInfo = MockDAO.getInstance().findCarByNo(carNo);
		if(carInfo == null)
			path = "findcar-fail.jsp";
		else
			path = "findcar-ok.jsp";
			request.setAttribute("car", carInfo);
		
		return path;
	}
	
}
