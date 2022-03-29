package org.kosta.webstudy15.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBInfo;

public class ProductDAO {
	//class loading시 instance 변수에 객체 주소값이 저장됨
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {
		System.out.println("ProductDAO 생성되었습니다.");
	}
	
	//외부에서 현 객체를 이용할 수 있도록 getInstance() method 생성
	public static ProductDAO getInstance() {
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
	
	public ProductVO findProductById(String id) throws SQLException {
		ProductVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			
			con=getConnection();
			String sql = "SELECT ID, NAME, MAKER, PRICE FROM web_product WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				 vo = new ProductVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

			return vo;
		}finally {
			closeAll(rs, pstmt, con);
		}

	}

	public ArrayList<ProductVO> getAllProductList() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			ArrayList<ProductVO> list = new ArrayList<ProductVO>();
			
			con = getConnection();
			String sql = "SELECT ID, NAME, MAKER, PRICE FROM web_product ORDER BY ID DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductVO(rs.getInt("id"), rs.getString("name"), rs.getString("maker"), rs.getInt("price")));
			}
			
			return list;
			
		}finally {
			closeAll(rs, pstmt, con);
		}
	}

	public void register(ProductVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		con = getConnection();
		String sql = "INSERT INTO web_product(id, name, maker, price) VALUES (web_product_seq.nextval, ?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getMaker());
		pstmt.setInt(3, vo.getPrice());
		int count = pstmt.executeUpdate();
		
		System.out.println(count+" Columns have been updated.");
		
	}
}
