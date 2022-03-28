package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class FindMemberByIdServlet
 */
@WebServlet("/FindMemberByIdServlet")
public class FindMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindMemberByIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("memberId");
		try {
			MemberVO vo = dao.findMemberByID(id);
			
			if(vo!=null) {
				request.setAttribute("info", vo);
				request.getRequestDispatcher("findbyid-success.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("findbyid-fail.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 *  client로 부터 검색할 회원의 아이디를 받아온다.
		 *  Model: MemberDAO의 findMemberById(id) 메서드 호출
		 */
	}

}
