package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public ArrayList<MemberVO> findMemberListByAddress(String address) throws Exception {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT id, password, name, TO_CHAR(birthday, 'yyyy-mm-dd') as bir, TO_CHAR(regdate, 'yyy-mm-dd HH24:MM:SS') as reg FROM mvc_member WHERE address=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), address, rs.getString("bir"), rs.getString("reg")));
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}

	public void update(MemberVO vo) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE mvc_member SET password=?, name=?, address=?, birthday=TO_DATE(?,'yyyy-mm-dd') WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getBirthday());
			pstmt.setString(5, vo.getId());
			int result = pstmt.executeUpdate();
			
			System.out.println(result+"Columns have been updated");
			
		}finally {
			closeAll(pstmt, con);
		}
	}

	public void register(MemberVO vo) throws Exception {
		/*
		 * SQLException하면 왜 안되지?
		 */
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO mvc_member(id, password, name, address, birthday, regdate) VALUES(?, ?, ?, ?, TO_DATE(?, 'yyyy-mm-dd'), sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getBirthday());
			
			int result = pstmt.executeUpdate();
			System.out.println(result+" Columns have been updated");
			
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public boolean checkId(String id) throws Exception {
		boolean result = false;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM mvc_member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()&&rs.getInt(1)==1)
				result = true;
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
}
