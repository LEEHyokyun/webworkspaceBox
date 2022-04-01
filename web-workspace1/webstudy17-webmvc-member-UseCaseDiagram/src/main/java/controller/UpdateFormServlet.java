package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet("/UpdateFormServlet")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String url = null;
		if(session==null || session.getAttribute("mvo")==null) {
			url="index.jsp";
		}else {
			url="update-form.jsp";
		}
		response.sendRedirect(url);
	}

}
