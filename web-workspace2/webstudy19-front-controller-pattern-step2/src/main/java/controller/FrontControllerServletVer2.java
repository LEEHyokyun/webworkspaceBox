package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

/**
 * 리팩토링1 : doDispatcher 비대화를 방지, command에 따른 메소드 생성 및 dispatcher 호출
 */
//@WebServlet("/FrontControllerServlet")
public class FrontControllerServletVer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontControllerServletVer2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * client 요청분석 : command value
			 */
		String command = request.getParameter("command");
		if(command.equals("findCarByNo")) {
		//차번호 검색
			findCarByNo(request, response);
		}else if(command.equals("registerCar")) {
			registerCar(request, response);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
	
	protected void registerCar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String carInfo = request.getParameter("carInfo");
		MockDAO.getInstance().register(carInfo);
		response.sendRedirect("registercar-result.jsp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}

}
