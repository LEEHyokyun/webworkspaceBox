package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 * module v3.1, annotation 설정 가능
 */
@WebServlet(urlPatterns="/LifeCycleServlet", loadOnStartup = 1, initParams= {@WebInitParam(name="springconfig", value="springmvc.xml")})
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleServlet() {
        super();
        System.out.println(getClass().getName()+"의 객체가 생성되었습니다."); //class명 반환
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("init() method가 호출되었습니다.");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//socket prograaming 구조와 유사!
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println("GetTestServlet");
		String info = getServletConfig().getInitParameter("springconfig");
		out.println(info);
		out.println("<br><br>");
		//servlet context는 application내 servlet과 jsp가 공유받을 수 있는 공유자원이다.
		String commonInfo = (String) getServletConfig().getServletContext().getAttribute("commonInfo");
		//downcasting, object -> String
		out.println(commonInfo);
		out.println("<br><br>");
		out.println("<a href=test.jsp>test.jsp로 이동합니다</a>");
		out.println("<br><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() method가 호출되었습니다.");
	}
}
