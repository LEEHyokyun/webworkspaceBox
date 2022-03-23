package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count;
    private String savePath="C:\\kosta238\\count.txt";
    
    public CountServlet() {
        super();
        System.out.println("CountServlet");
    }
    
    @Override
    	public void init() throws ServletException {
    		// TODO Auto-generated method stub
    		System.out.println("init 실행");
    		count++; //문장실행후 증감연산 실행
    	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//socket prograaming 구조와 유사!
		out.println("service()가 호출되어 get이 실행되었습니다.");
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println("<h2>"+getServletName()+"의 count는: "+count+"</h2>");
		count++;
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method가 실행되었습니다.");
	}
}
