package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetCookieServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//socket prograaming 구조와 유사!
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println("GetTestServlet");
		out.println("<br><br>");
		//cookie value 저장시 공란을 허용하지 않는다.
		Cookie cookie = new Cookie("info", new Date().toString().replace(" ","-"));
		cookie.setMaxAge(30);
		response.addCookie(cookie); //이 설정정보를 res를 통해 client에게 전달한다.
		/*
		 * cookie 유효시간 설정 : 기본적으로 client, 즉 application이 종료된다면 cookie는 소멸된다.
		 */
		out.println("<br><br>");
		out.println("<a href=GetCookieServlet>GetCookieServlet으로 이동하여 cookie 값을 확인합니다.</a>");
		out.println("<br><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}

}
