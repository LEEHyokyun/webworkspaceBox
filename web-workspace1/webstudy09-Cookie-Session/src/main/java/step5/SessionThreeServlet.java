package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionThreeServlet
 */
@WebServlet("/SessionThreeServlet")
public class SessionThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionThreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//socket prograaming 구조와 유사!
		out.println("<html>");
		out.println("<body bgcolor=orange>");
		out.println("GetTestServlet");
		out.println("<br><br>");
		//session정보 반환
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
			System.out.println("session 정보를 무효화하였습니다.");
		}else {
			System.out.println("session 정보가 존재하지 않습니다.");
		}
		out.println("<br><br>");
		out.println("<a href=SessionOneServlet>SessionOneServelt으로 이동합니다.</a>");
		out.println("<a href=SessionTwoServlet>SessionTwoServelt으로 이동합니다.</a>");
		out.println("<br>");
		out.println("<br><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
