package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// db table에 저장
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String viewUrl = null;
		if(id.equals("java") && password.equals("abcd")) {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", new MemberVO(id, password, "아이유", "오리"));
			viewUrl = "session-test5-mvc-login-ok.jsp";
		}else {
			viewUrl = "session-test5-mvc-login-fail.jsp";
		}
		response.sendRedirect(viewUrl);
	}
}
