package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.DBInfo;

public class MemberDAO {
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null)
			rs.close();
		closeAll(pstmt, con);
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASS);
	}
	
	public int getAllMemberCount() throws SQLException {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT COUNT(*) FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				count = rs.getInt(1);
			
			return count;
			
		}finally {
			closeAll(rs, pstmt, con);
		}
	}
	
	public MemberVO findMemberByID(String id) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT name, address FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO(id, rs.getString(1), rs.getString(2));
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}
}
