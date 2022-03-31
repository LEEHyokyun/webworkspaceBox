package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta238.webstudy17.model.MemberDAO;
import org.kosta238.webstudy17.model.MemberVO;

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
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPw");
		
		try {
			MemberVO vo = MemberDAO.getInstance().login(id, password);
			
			if(vo != null){
				//id, name, address에 대한 정보를 server에 저장
				//이 저장된 정보를 얻어오기 위해 cookie에 저장된 Jsessionid 및 value가 필요.
					HttpSession session = request.getSession();
					session.setAttribute("mvo", vo);
					response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("login-fail.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
