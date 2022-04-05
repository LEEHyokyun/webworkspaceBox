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
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontControllerServlet() {
        super();   
    }

    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//client 요청분석 : by url pattern, command는 의미없음
			String uri = request.getRequestURI();
			String uriContext = request.getContextPath();
			String command = uri.substring(uriContext.length()+1, uri.length()-3);
			String path = null;
			/*
			 * command는 url을 통해 전달, hidden type 필요없음.
			 */
			Controller controller = HandlerMapping.getInstance().create(command);
			//HandlerMapping으로 담당 controller를 최종 생성
			
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
			//error.jsp
			response.sendRedirect("error.jsp");
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
