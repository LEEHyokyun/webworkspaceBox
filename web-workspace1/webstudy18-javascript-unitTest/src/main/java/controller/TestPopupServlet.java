package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPopupServlet
 */
@WebServlet("/TestPopupServlet")
public class TestPopupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestPopupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO를 이용하여 id 중복여부 확인
		String id = request.getParameter("id");
		System.out.println("model과 연동하여 id중복여부를 확인, 입력 아이디는: "+id);
		request.getRequestDispatcher("step4-popup.jsp").forward(request, response);
	}

}
