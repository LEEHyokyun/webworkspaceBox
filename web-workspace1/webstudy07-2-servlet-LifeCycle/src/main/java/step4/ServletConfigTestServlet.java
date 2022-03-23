package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigTestServlet
 */
public class ServletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConfigTestServlet() {
        super();
    }
    /*
     * web.xml에서 설정한 servlet config의 init parameter 받아오기 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//socket prograaming 구조와 유사!
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println(getServletName());
		//contextConfigLocation은 약속된 이름, 설정된 이름으로 config 정보를 받아온다.
		String frameworkInfo = this.getServletConfig().getInitParameter("ContextConfigLocation");
		//=this.getServletConfig().getServletName();
		out.println("ServletConfig로부터 프레임워크 설정파일 정보를 얻어왔습니다: "+frameworkInfo);
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}

}
