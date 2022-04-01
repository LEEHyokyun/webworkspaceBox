package org.kosta238.webstudy17.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

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

	public ArrayList<MemberVO> findMemberListByAddress(String address) throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT ID, NAME FROM member WHERE ADDRESS=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("ID"), rs.getString("NAME"), address));
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}

	public void updateMember(MemberVO vo) throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			//DB수정
			con = getConnection();
			String sql = "UPDATE member SET PASSWORD=?, NAME=?, ADDRESS=? WHERE id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4,  vo.getId());
			int result = pstmt.executeUpdate();
			System.out.println(result+" Columns have been updated");
			
		}finally {
			closeAll(pstmt, con);
		}
		
		
	}

	public void register(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "INSERT INTO member(id, password, name, address) VALUES(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			int result = pstmt.executeUpdate();
			
			System.out.println(result+" Columns have been updated");
			
			
		}finally {
			closeAll(pstmt, con);
		}
		
		
	}
}
