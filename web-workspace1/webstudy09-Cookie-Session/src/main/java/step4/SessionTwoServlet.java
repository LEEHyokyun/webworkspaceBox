package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberVO;

@WebServlet("/SessionTwoServlet")
public class SessionTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		//기존 session이 있다면 반환받고, 없으면 null을 반환한다.
		HttpSession session = request.getSession(false);
		if(session != null) {
			//session에 저장된 MemberVO 객체를 반환받는다(Object return, type casting 필요).
			MemberVO vo=(MemberVO) session.getAttribute("mvo");
			if(vo!=null) {
				out.println("<br>세션에 저장된 회원의 아이디는: "+vo.getId());
				out.println("<br>세션에 저장된 회원의 이름은: "+vo.getName());	
			}else {
				out.println("session에 회원객체가 존재하지 않습니다.");
			}
		}else {
			System.out.println("Session이 존재하지 않습니다.");
		}
		out.println("<br>");
		out.println("<a href=SessionOneServlet>SessionOneServelt으로 이동합니다.</a>");
		out.println("<a href=SessionThreeServlet>SessionThreeServelt으로 이동합니다.</a>");
		out.println("<br><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
