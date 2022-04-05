package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class FindAllCarListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> carList = new ArrayList<String>();
		carList = MockDAO.getInstance().findAllCarList();
		
		request.setAttribute("carList", carList);
		
		return "findcar-list.jsp";
	}

}
