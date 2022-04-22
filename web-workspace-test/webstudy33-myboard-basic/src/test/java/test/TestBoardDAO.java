package test;

import java.util.ArrayList;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.MemberVO;
import org.kosta.myproject.model.PostVO;

public class TestBoardDAO {
	public static void main(String[] args) {
		BoardDAO dao = BoardDAO.getInstance();
		
		try {
			//게시물 리스트 조회
			/*
			 * ArrayList<PostVO> list = dao.findPostList(); for(PostVO vo:list) {
			 * System.out.println(vo.getMemberVO().getName()); }
			 */
			
			//상세 게시글 조회
			/*
			 * String no = "22"; PostVO vo = dao.findPostByNo(no);
			 * System.out.println(vo.getTitle());
			 */
			
			//게시글 작성
			/*
			 * 글쓰기 -> content뿐만 아니라 관련 value 모두 DB에 저장되어야 한다!
			 */
			/*
			 * MemberVO mvo = new MemberVO("java", null, null); PostVO pvo = new PostVO();
			 * pvo.setTitle("타로킹"); pvo.setContent("영험한 기운"); pvo.setMemberVO(mvo);
			 * dao.posting(pvo); System.out.println("글쓰기가 완료되었습니다.");
			 */
			
			//조회수 작성
			/*
			 * String no = "22"; dao.updateHits(no); System.out.println("조회수 증가"); PostVO
			 * pvo = dao.findPostByNo(no); System.out.println(pvo.getHits());
			 */
			
			//게시글 삭제
			String no = "23";
			dao.deletePostByNo(no);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
