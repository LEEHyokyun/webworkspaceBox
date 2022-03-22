package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
//해당 서블릿에 요청하여 실행하기 위해 특정 url을 기술하는 어노테이션
public class HelloServlet extends HttpServlet { //모든 서블렛과 JSP는 HttpServlet을 상속
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * doGet : client가 get 방식으로 요청할때 실행되는 메서드
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //화면출력준비
		out.print("HelloServlet doGet이 실행되었습니다."); //화면출력
		out.close();
	}

	/**
	 * doPost : client가 post 방식으로 요청할때 실행되는 메서드
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doPost");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //화면출력준비
		out.print("HelloServlet doGet이 실행되었습니다."); //화면출력
		out.close();
	}

}
