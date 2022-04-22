package test;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class TestMemberDAO {
	public static void main(String[] args) {
		MemberDAO dao = MemberDAO.getInstance();
		try {
			MemberVO vo = dao.login("java", "a");
			System.out.println(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
