package test;

import java.sql.SQLException;

import org.kosta.myproject.model.MemberDAO;

public class TestMemberDAO {
	public static void main(String[] args) {
		MemberDAO dao = MemberDAO.getInstance();
		try {
			dao.UnitTest();
			System.out.println(dao.findMemberById("java"));
			System.out.println(dao.findMemberById("java2"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
