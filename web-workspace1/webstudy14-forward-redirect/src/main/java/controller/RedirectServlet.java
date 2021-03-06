package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RedirectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Controller에서 View로의 이동, by redirect
		System.out.println(getServletName()+"의 doGet() 메서드가 실행되었습니다.");
		
		request.setAttribute("productInfo", "진라면 오뚜기");
		
		response.sendRedirect("redirect-result.jsp");
		//redirect 시점에 완전히 새로운 요청경로로 이동, request 제거.
	}

}
