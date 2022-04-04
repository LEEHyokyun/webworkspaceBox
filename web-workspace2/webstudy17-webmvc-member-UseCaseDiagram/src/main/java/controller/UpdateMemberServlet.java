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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 한글에 대해서는 request로 부터 data를 받아올떄부터 한글처리필요하다.
		 */
		request.setCharacterEncoding("utf-8");
		
		String updatedId = request.getParameter("memberId");
		String updatedPassword = request.getParameter("memberPassword");
		String updatedName = request.getParameter("memberName");
		String updatedAddress = request.getParameter("memberAddress");
		
		MemberVO vo = new MemberVO(updatedId, updatedPassword, updatedName, updatedAddress);
		
		try {
			MemberDAO.getInstance().updateMember(vo);
			
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.setAttribute("mvo", vo);
				response.sendRedirect("update-result.jsp");
			}else if(session == null || session.getAttribute("mvo") ==null)
				response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
