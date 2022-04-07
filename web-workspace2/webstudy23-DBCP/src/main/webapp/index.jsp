<%@page import="org.kosta.myproject.model.DataSourceManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<h3>Database connection pool</h3>
<br><br>
<%
	String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	Connection con = DriverManager.getConnection(dbUrl, "scott", "tiger");
%>
<%=con.getClass() %>
<%
	con.close();
%>
<br><br>
DBCP(DataSource, 정확히 말하면 해당 구현체)를 이용한 DB connect!
<br>
<%
	DataSource datasource = DataSourceManager.getInstance().getDataSource();
	Connection dbcpCon = datasource.getConnection(); //커넥션 풀에서 커넥션 대여
%>
<%=dbcpCon.getClass()%>
<%
	dbcpCon.close();
%>
</body>
</html>