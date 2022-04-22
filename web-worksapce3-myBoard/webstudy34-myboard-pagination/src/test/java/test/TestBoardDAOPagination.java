package test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.Pagination;
import org.kosta.myproject.model.PostVO;

public class TestBoardDAOPagination {
	BoardDAO dao = BoardDAO.getInstance();
	
	public static void main(String[] args) {
		try {
			TestBoardDAOPagination test = new TestBoardDAOPagination();
			test.testTotalPostCount();
			test.testFindPostList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void testFindPostList() throws Exception{

		int nowPage =3;
		Pagination pagination = new Pagination(dao.getTotalPostCount(), nowPage);
		ArrayList<PostVO> list = dao.findPostList(pagination);
		
		for(PostVO vo:list)
			System.out.println(vo);
	}
	
	void testTotalPostCount() throws Exception{
		
		int totalPostCount = dao.getTotalPostCount();
		System.out.println(totalPostCount);
	}
		
}
