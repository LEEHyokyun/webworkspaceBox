package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

/**
 * 리팩토링2 : 각 개별 메소드를 독립적인 시스템 개발 단위로 분화 및 Servlet 분화운영 FrontControllerServlet을
 * 분할된 메소드에 따라 개별 Servlet(=class)으로 다시 세부 분화
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServletVer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontControllerServletVer3() {
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
			
			if (command.equals("findCarByNo")) {
				// 차번호 검색
				FindCarByNoController controller = new FindCarByNoController();
				controller.findCarByNo(request, response);
			} else if (command.equals("registerCar")) {
				RegisterCarController controller = new RegisterCarController();
				controller.registerCar(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
