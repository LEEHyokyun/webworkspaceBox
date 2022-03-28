package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

/**
 * Servlet implementation class AllMemberCountServlet
 */
@WebServlet("/AllMemberCountServlet")
public class AllMemberCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AllMemberCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		try {
			//전체 회원수를 반환받는다.
			int count = dao.getAllMemberCount();
			// Model과 연동하여 View가 사용하게 하도록 request 객체에 저장
			request.setAttribute("totalCount", count);
			// client에게 응답하는 역할을 하는 view로 이동
			// forward 방식 : 기존의 req, res를 유지한채 서버상 제어를 이동시킨다(여기서는 controller -> view)
				// ㄴ 쉽게 말하면 서버상에서 req, res의 이동이 특정 구간으로 전달되도록 유지한다.
			request.getRequestDispatcher("member-count.jsp").forward(request, response);
		} catch (SQLException e) {
		
		}
	}

}
