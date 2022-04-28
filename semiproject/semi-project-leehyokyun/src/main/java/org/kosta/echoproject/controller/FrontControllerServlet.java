package org.kosta.echoproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontControllerServlet() {
		super();
	}

	// FCServlet - Controller 객체를 배당 및 생성하는 Factory object.
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// client 요청을 분석, url을 통해 controller 명 추출
			String uri = request.getRequestURI();
			System.out.println(uri);
			String uriContext = request.getContextPath();
			System.out.println(uriContext);
			String controllerName = uri.substring(uriContext.length()+1, uri.length()-3);
			//인증체크 공통정책
			
			  boolean result = CheckLoginInterceptor.getInstance().checkLogin(request, controllerName); 
			  if(!result) {
				  response.sendRedirect("index.jsp"); 
				  return;
			  }
			  //redirect후 해당 메서드 실행 종료 }
			 
			
			Controller controller = HandlerMapping.getInstance().create(controllerName);
			System.out.println(controller);
			String path = controller.execute(request, response);
			
			if(path.startsWith("redirect:"))
				response.sendRedirect(path.substring(9));
			else
				request.getRequestDispatcher(path).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
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
