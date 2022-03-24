package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberVO;

/**
 * Servlet implementation class SessionOneServlet
 */
@WebServlet("/SessionOneServlet")
public class SessionOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionOneServlet() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//socket prograaming 구조와 유사!
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println("GetTestServlet");
		out.println("<br><br>");
		out.println("<br><br>");
		//기존 session이 있다면 반환받는다.
		HttpSession session = request.getSession();
		out.println("session id는: "+session.getId()+"<br>");
		//session에 memberVO "객쳬" 저장
		session.setAttribute("mvo", new MemberVO("java","abcd","아이유","종로"));
		out.println("session에 객체를 저장하였습니다.");
		out.println("<a href=SessionTwoServlet>SessionTwoServelt으로 이동합니다.</a>");
		out.println("<br><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
