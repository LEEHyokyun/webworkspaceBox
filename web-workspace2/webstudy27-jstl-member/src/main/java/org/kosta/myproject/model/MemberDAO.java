package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DataSource dataSource;

	private MemberDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource(); //DBCP 대여
	};

	public static MemberDAO getInstance() {
		return instance;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws Exception {
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

	public void UnitTest() throws SQLException {
		System.out.println(dataSource.getConnection());
	}

	public MemberVO findMemberById(String id) throws Exception {
		MemberVO vo = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT id, password, name, address, TO_CHAR(birthday,'yyyy-mm-dd') as bir, TO_CHAR(regdate, 'yyyy-mm-dd HH24:MM:SS') as reg FROM mvc_member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				vo = new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address"), rs.getString("bir"), rs.getString("reg"));
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		System.out.println(vo);
		return vo;	
	}

	public MemberVO login(String id, String password) throws Exception {
		MemberVO vo = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT name, address, TO_CHAR(birthday, 'yyyy-mm-dd') as bir, TO_CHAR(regdate, 'yyy-mm-dd HH24:MM:SS') as reg FROM mvc_member WHERE id=? AND password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next())
				vo = new MemberVO(id, password, rs.getString("name"), rs.getString("address"), rs.getString("bir"), rs.getString("reg"));
			
		}finally{
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}

}
