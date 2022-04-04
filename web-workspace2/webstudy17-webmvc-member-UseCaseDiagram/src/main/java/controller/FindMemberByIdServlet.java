package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta238.webstudy17.model.MemberDAO;
import org.kosta238.webstudy17.model.MemberVO;

/**
 * Servlet implementation class FindMemberByIdServlet
 */
@WebServlet("/FindMemberByIdServlet")
public class FindMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindMemberByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("memberId");
		MemberVO vo = new MemberVO();
		try {
			vo = MemberDAO.getInstance().findMemberById(id);
			if(vo!=null) {
				request.setAttribute("MemberVO", vo);
				request.getRequestDispatcher("findbyid-ok.jsp").forward(request, response);;
			
			}else {
				request.getRequestDispatcher("findbyid-fail.jsp").forward(request, response);;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
