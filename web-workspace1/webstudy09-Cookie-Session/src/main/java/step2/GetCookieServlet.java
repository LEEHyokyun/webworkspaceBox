package step2;

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
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//socket prograaming 구조와 유사!
		out.println("<html>");
		out.println("<body bgcolor=lime>");
		out.println("GetTestServlet");
		out.println("<br><br>");
		//Cookie 정보 확보(return list)
		/*
		 * req 단에서 cookie 정보 조회 및 확보가 이루어지며, 특정 cookie 정보가 있을 경우에 cookie list 반환
		 */
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			//cookie 정보있으면 주소값 반환, 없으면 null
			boolean flag = false;
			/*
			 * cookie가 존재하는지, 특정 cookie가 존재하는지 확인한다.
			 */
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("info")) {
					out.println("<br>client info is: "+cookies[i].getValue()+"<br>");
					flag=true;
					break;
				}
			}
			if(flag==false) {
				out.println("Info cookie가 존재하지 않습니다.<br><br>");
			}
		}else {
			out.println("cookie가 존재하지 않습니다.");
		}
		out.println("<br>");
		out.println("<br><br>");
		out.println("<a href=SetCookieServlet>SetCookieServlet으로 이동합니다.</a>");
		out.println("<br><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}

}
