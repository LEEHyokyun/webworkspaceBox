package step6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextTestServlet2
 */
public class ContextTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextTestServlet2() {
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
		//ServletContext의 정보는 웹 어플리케이션 내 모든 servlet과 jsp에서 사용가능한 공유자원이다.
		//init(servletconfig) 메서드가 container에 의해 실행될때 servletconfig를 전달받는다 => context 객체(주소)정보 반환
		ServletContext context = this.getServletConfig().getServletContext();
		//String adminEmail=this.getServletConfig().getServletContext().getInitParameter("adminEmail");
		String adminEmail = context.getInitParameter("adminEmail");
		out.println("<br><br>ServletContext의 init param 정보는 : "+adminEmail);
		//Servlet2에서 Servlet1이 할당한 정보를 반환(Get)받는다.
		out.println("<br><br>ServletContext1에 저장된 nick param 정보는 : "+context.getAttribute("nick"));
		out.println("<br><br><a href='ContextTestServlet1'>ContextTestServlet1로 이동합니다.</a>");
		out.println("<br><br><a href='test.jsp'>test.jsp로 이동합니다.</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}

}
