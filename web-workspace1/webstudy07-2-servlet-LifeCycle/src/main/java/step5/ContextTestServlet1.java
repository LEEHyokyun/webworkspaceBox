package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextTestServlet1
 */
/*
 * Servlet context 정보는 web application내 servlet과 jsp 모두 접근할 수 있는 자원이다.
 * Servlet context를 Servlet 객체가 접근하여 사용, 각 servlet이 context에 할당한 정보를 다른 servlet/jsp 객체에서 확인
 */
public class ContextTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextTestServlet1() {
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
		//init(servletconfig) 메서드가 container에 의해 실행될때 servletconfig를 전달받는다 => context 객체(주소)정보 반환
		ServletContext context = this.getServletConfig().getServletContext();
		//String adminEmail=this.getServletConfig().getServletContext().getInitParameter("adminEmail");
		String adminEmail = context.getInitParameter("adminEmail");
		out.println("<br><br>ServletContext의 init param 정보는 : "+adminEmail);
		out.println("<br><br><a href='ContextTestServlet2'>ContextTestServlet2로 이동합니다.</a>");
		context.setAttribute("nick", "ServletContext에 저장된 정보는 아이유");
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}

}
