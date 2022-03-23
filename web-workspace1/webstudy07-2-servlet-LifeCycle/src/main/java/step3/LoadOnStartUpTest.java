package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadOnStartUpTest
 */
public class LoadOnStartUpTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoadOnStartUpTest() {
        super();
        System.out.println("LoadOnStartUpTest 객체 생성");
    }
    
    @Override
    	public void init() throws ServletException {
    		System.out.println("LoadOnStartUp init");
    	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//socket prograaming 구조와 유사!
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println(getServletName());
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}
	
	@Override
	public void destroy() {
		System.out.println("LoadOnStartUp Destroy");
	}

}
