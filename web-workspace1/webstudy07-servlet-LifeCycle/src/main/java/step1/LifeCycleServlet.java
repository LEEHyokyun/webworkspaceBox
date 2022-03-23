package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 * module ver 2.5
 */

public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	//생성자, 최초실행 1번만 실행된다(어느 브라우저에서 작동시키든 최초 실행1번, 다시 regenerate = 최초실행)
    public LifeCycleServlet() {
        super();
        System.out.println("LifeCycleServlet 객체가 생성되었습니다.");
    }
    
  //생성자는 아니지만 유사동작, 최초실행 1번만 실행된다(어느 브라우저에서 작동시키든 최초 실행1번, 다시 regenerate = 최초실행)
    @Override
    public void init() throws ServletException {
    	System.out.println("init()");
    }
	/**
	 * web container가 service() 메소드를 호출하면 내부적으로 요청방식에 따라  
	*/
    //호출될때마다 매번 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() is called");
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
	
	//WAS/Servlet 종료(stop)시 destroy 실행
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
}
