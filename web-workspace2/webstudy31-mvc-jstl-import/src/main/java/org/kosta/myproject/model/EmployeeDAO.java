package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private DataSource dataSource;

	private EmployeeDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	};

	public static EmployeeDAO getInstance() {
		return instance;
	};

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

	public int findEmpTotalCount() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT COUNT(*) FROM mvc_employee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return totalCount;
	}

	public ArrayList<EmployeeVO> findAllEmployeeList() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO evo = new EmployeeVO();
		DepartmentVO dvo = new DepartmentVO();
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		
		try {
			StringBuffer sql = new StringBuffer("SELECT e.empno, e.ename, d.dname, d.loc ");
			sql.append("FROM mvc_department d ");
			sql.append("INNER JOIN mvc_employee e ");
			sql.append("ON e.deptno = d.deptno");
			/*
			 * OUTER JOIN으로 인해 ename 변수가 null일 경우, SQL 오류로 인해 404error 발생
			 */
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
		
				dvo = new DepartmentVO(rs.getString("dname"), rs.getString("loc"));
				evo = new EmployeeVO(rs.getInt("empno"), rs.getString("ename"), dvo);
				/*
				 * DepartmentVO dvo = new DepartmentVO("rs.getString("dname"), rs.getString("loc"));
				 * list.add(new EmployeeVO(rs.getString("ename"), dvo));
				 */
				list.add(evo);
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}

	public EmployeeVO findEmployeeByNo(String empno) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO evo = null;
		
		try {
			StringBuffer sql = new StringBuffer("SELECT e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc, d.tel ");
			sql.append("FROM mvc_employee e ");
			sql.append("INNER JOIN mvc_department d ");
			sql.append("ON e.deptno = d.deptno ");
			sql.append("WHERE e.empno = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, empno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				DepartmentVO dvo = new DepartmentVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"), rs.getString("tel"));
				evo = new EmployeeVO(rs.getInt("empno"), rs.getString("ename"), rs.getInt("sal"), dvo);
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return evo;
	}

	public ArrayList<HashMap<String, String>> findEmpCountGroupByDept() throws Exception {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuilder sql = new StringBuilder("SELECT d.dname, d.loc, count.deptno, NVL(count.emp_no,0) as emp_no ");
			sql.append("FROM mvc_department d ");
			sql.append("LEFT OUTER JOIN( ");
			sql.append("SELECT deptno, COUNT(*) as emp_no ");
			sql.append("FROM mvc_employee ");
			sql.append("GROUP BY deptno ");
			sql.append(") count ");
			sql.append("ON d.deptno = count.deptno ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
				map.put("emp_no", rs.getString("emp_no"));
				list.add(map);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
}
