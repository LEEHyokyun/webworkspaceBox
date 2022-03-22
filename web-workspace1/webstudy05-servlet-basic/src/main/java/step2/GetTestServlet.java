package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTestServlet
 */
@WebServlet("/GetTestServlet")
public class GetTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * HttpServletRequest : client의 요청 정보를 저장하는 객체
	 * HttpServletResponse : client에게 응답하기위한 정보를 저장하는 객체
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			//socket prograaming 구조와 유사!
			out.println("<html>");
			out.println("<body bgcolor=yellow>");
			String info=request.getParameter("food");
			String info2=request.getParameter("count");
			out.println("GetTestServlet 점심메뉴: "+ info+" "+info2+"인분");
			out.println("</body>");
			out.println("</html>");
			//향후 view는 JSP가 담당한다.
			out.close();
	}

}
