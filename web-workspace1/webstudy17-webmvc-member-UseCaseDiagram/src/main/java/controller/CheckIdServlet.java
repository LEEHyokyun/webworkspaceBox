package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta238.webstudy17.model.MemberDAO;

/**
 * Servlet implementation class CheckIdServlet
 */
@WebServlet("/CheckIdServlet")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 일단 아이디는 입력된 상태임
		 */
		String id =request.getParameter("id");
		
		try {
			boolean isChecked = MemberDAO.getInstance().checkId(id);
			//System.out.println(isChecked);
			if(isChecked) { //true, ID 존재, 즉 중복
				request.getRequestDispatcher("check-id-fail.jsp").forward(request, response);
			}else { //false, ID 미존재, 미중복
				request.getRequestDispatcher("check-id-ok.jsp").forward(request, response);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
