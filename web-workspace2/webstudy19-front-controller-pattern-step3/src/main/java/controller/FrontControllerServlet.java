package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontControllerServlet() {
        super();   
    }

    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//client 요청분석
			String command = request.getParameter("command");
			String path = null;
			Controller controller = null;
			//객체생성
			if(command.equals("findCarByNo")) {
				controller = new FindCarByNoController();
			}else if(command.equals("registerCar")) {
				controller = new RegisterCarController();
			}else if(command.equals("findAllCarList")) {
				controller = new FindAllCarListController();
			}
			/*
			 * 객체생성 부분도 결합도가 높다.
			 * 개선대상이다.
			 */
			path = controller.execute(request, response);	
			if(path.startsWith("redirect:")) {
				//redirect
				response.sendRedirect(path.substring(9));
			}else {
				//forward
				request.getRequestDispatcher(path).forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}

}
