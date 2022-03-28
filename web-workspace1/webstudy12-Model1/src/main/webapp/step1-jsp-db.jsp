<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%
	String driver="oracle.jdbc.OracleDriver";
	Class.forName(driver);
	//System.out.println("Db driver Loading");
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	Connection con = DriverManager.getConnection(url, "scott", "tiger");
	//System.out.println("Db Connected");
	String sql="SELECT COUNT(*) FROM member";
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	int count = 0;
	if(rs.next()){
		count=rs.getInt(1);
	}
	rs.close();
	pstmt.close();
	con.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	JSP와 데이터베이스가 연동되었습니다. <br><br>
	전체 회원수는 <%=count %>명 입니다.
</body>
</html>