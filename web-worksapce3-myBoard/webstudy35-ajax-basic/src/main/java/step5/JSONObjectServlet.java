package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.CarDAO;
import model.CarDTO;

/**
 * Servlet implementation class JSONObjectServlet
 */
@WebServlet("/JSONObjectServlet")
public class JSONObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String maker=request.getParameter("maker");
		CarDTO carDTO=CarDAO.getInstance().getCarInfo(maker);
		//객체 data를 JSON형식으로 반환, 구조화된 데이터로 통신
		JSONObject json = new JSONObject(carDTO);
		out.println(json.toString());
		out.close();
	}
}

















