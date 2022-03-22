package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBoxServlet
 */
@WebServlet("/CheckBoxServlet")
public class CheckBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// socket prograaming 구조와 유사!
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println(getServletName());
		//checkbox, 동일 name으로 여러 value가 전달 -> requestgetParameterValues(name)
		String[] menuList = request.getParameterValues("menu");
		for(int i=0;i<menuList.length;i++) {
			out.println(menuList[i]+", ");
		}
		out.println("</body>");
		out.println("</html>");
		// 향후 view는 JSP가 담당한다.
		out.close();
	}

}
