package org.kosta238.webstudy17.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.DBInfo;
/*
 * Singleton pattern
 */
public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		System.out.println("MemberDAO 객체가 생성되었습니다.");
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
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

	public MemberVO findMemberById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			MemberVO vo = null;
			
			con = getConnection();
			String sql = "SELECT NAME, ADDRESS FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				vo = new MemberVO(id, rs.getString("name"), rs.getString("address"));
			
			System.out.println(vo);
			return vo;
			
		}finally{
			closeAll(rs, pstmt, con);
		}

	}

	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT NAME, ADDRESS FROM member WHERE ID=? and PASSWORD=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				vo = new MemberVO(id, rs.getString("NAME"), rs.getString("ADDRESS"));
				
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}
}
