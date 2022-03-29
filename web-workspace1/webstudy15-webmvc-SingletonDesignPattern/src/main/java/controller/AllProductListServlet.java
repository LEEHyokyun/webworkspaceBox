package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy15.model.ProductDAO;
import org.kosta.webstudy15.model.ProductVO;

/**
 * Servlet implementation class AllProductListServlet
 */
@WebServlet("/AllProductListServlet")
public class AllProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AllProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		try {
			list = ProductDAO.getInstance().getAllProductList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("product-list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
