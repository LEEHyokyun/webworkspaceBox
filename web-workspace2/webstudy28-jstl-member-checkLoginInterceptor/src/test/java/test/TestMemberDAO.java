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
			System.out.println(dao.checkId("java")); //존재할 경우 true, 존재하지 않을 경우 false
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
