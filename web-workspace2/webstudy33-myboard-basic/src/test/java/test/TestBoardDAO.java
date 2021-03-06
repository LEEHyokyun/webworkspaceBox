package test;

import java.util.ArrayList;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class TestBoardDAO {
	public static void main(String[] args) {
		BoardDAO dao = BoardDAO.getInstance();
		
		try {
			ArrayList<PostVO> list = dao.findPostList();
			for(PostVO vo:list) {
				System.out.println(vo.getMemberVO().getName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
