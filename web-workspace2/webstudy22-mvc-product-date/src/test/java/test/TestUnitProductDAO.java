package test;

import java.sql.SQLException;

import org.kosta.myproject.model.ProductDAO;

public class TestUnitProductDAO {
	public static void main(String[] args) {
		//System.out.println(ProductDAO.getInstance().getConnection());
		ProductDAO dao = ProductDAO.getInstance();
		try {
			System.out.println(dao.findProductById("1"));
			//System.out.println(dao.register(new ProductVO()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
