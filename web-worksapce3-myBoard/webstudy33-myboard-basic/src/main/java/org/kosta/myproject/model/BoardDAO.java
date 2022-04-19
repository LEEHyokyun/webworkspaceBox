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
}
