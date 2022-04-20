package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private DataSource dataSource;

	private BoardDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	};

	public static BoardDAO getInstance() {
		return instance;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws Exception {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public ArrayList<PostVO> findPostList() throws Exception {
		ArrayList<PostVO> list = new ArrayList<PostVO>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try { 
			StringBuilder sql = new StringBuilder("SELECT b.no, b.title, m.name, TO_CHAR(time_posted, 'yyyy.mm.dd') as time_posted , b.hits ");
			sql.append("FROM member m ");
			sql.append("INNER JOIN board b ON m.id=b.id ");
			sql.append("ORDER BY b.no DESC");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO(rs.getString("name"));
				list.add(new PostVO(rs.getInt("no"), rs.getString("title"), rs.getInt("hits"), rs.getString("time_posted"), vo));
			}
			
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}

	public PostVO findPostByNo(String no) throws Exception {
		PostVO pvo = new PostVO();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			StringBuilder sql = new StringBuilder("SELECT b.no, b.title, b.content, b.hits, TO_CHAR(b.time_posted, 'yyyy.mm.dd HH24:MI:SS') as time_posted, m.name, m.id, m.password ");
			sql.append("FROM board b ");
			sql.append("INNER JOIN member m ON m.id=b.id ");
			sql.append("WHERE no=?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				MemberVO mvo = new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"));
				pvo = new PostVO(rs.getInt("no"), rs.getString("title"), rs.getString("content"), rs.getInt("hits"), rs.getString("time_posted"), mvo);
			}
			
			System.out.println(pvo);
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		return pvo;
	}
	
	public void posting(PostVO postVO) throws	Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO board(no, title, content, time_posted, id) VALUES(board_seq.nextval , ?, ?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, postVO.getTitle());
			pstmt.setString(2, postVO.getContent());
			pstmt.setString(3, postVO.getMemberVO().getId());
			pstmt.executeUpdate();
			
			
			
		}finally {
			closeAll(pstmt, con);
		}
		
	}
}
