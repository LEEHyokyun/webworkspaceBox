package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta238.webstudy17.model.MemberDAO;
import org.kosta238.webstudy17.model.MemberVO;

/**
 * Servlet implementation class FindMemberListByAddressServlet
 */
@WebServlet("/FindMemberListByAddressServlet")
public class FindMemberListByAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindMemberListByAddressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("mvo")==null) {
			/*
			 * 이동시점에서 session 확인, 없다면 다른 별도 페이지로 이동한다.
			 * 즉, 로그인을 하였더라도 시간이 오래 지나 인증정보가 session에 없는 상태
			 * 이를 파악하여 정보검색을 차단한다.
			 */
			System.out.println("비로그인 상태, 로그인이 해제되었습니다.");
			response.sendRedirect("index.jsp");
			return; //메소드 실행 중단
		}
		
		String address = request.getParameter("memberAddress");
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			list = MemberDAO.getInstance().findMemberListByAddress(address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("vo", list);
		request.getRequestDispatcher("findbyaddress-result.jsp").forward(request, response);;
	}

}
