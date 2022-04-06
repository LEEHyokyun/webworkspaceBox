package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.DBInfo;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();

	private ProductDAO() {
	};

	public static ProductDAO getInstance() {
		return instance;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASS);
	}

	public ProductVO findProductById(String productId) throws SQLException {
		ProductVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "SELECT ID, NAME, MAKER, PRICE, TO_CHAR(REGDATE, 'yyyy-mm-dd') as date_string FROM mvc_product WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				/*
				 * vo = new ProductVO(rs.getInt(1), rs.getString(2), rs.getString(3),
				 * rs.getInt(4), rs.getString(5));
				 */
				vo = new ProductVO(rs.getInt("ID"), rs.getString("NAME"), rs.getString("MAKER"), rs.getInt("PRICE"),
						rs.getString("date_string"));

			}

		} finally {
			closeAll(rs, pstmt, con);
		}

		System.out.println(vo);
		return vo;
	}

	public void register(ProductVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "INSERT INTO mvc_product(id, name, maker, price, regDate) VALUES(mvc_product_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMaker());
			pstmt.setInt(3, vo.getPrice());
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"Columns have been updated");
			
		}finally {
			closeAll(pstmt, con);
		}
		
	}
}
