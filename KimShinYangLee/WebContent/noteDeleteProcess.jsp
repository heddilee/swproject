<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
	request.setCharacterEncoding("euc-kr");

	usingDB db = new usingDB();
	Class.forName("com.mysql.jdbc.Driver");
	String url = db.url;
	String dbuser = db.dbuser;
	String dbpass = db.dbpass;
	int order = Integer.parseInt(request.getParameter("order"));

	try {
		Connection conn = DriverManager.getConnection(url, dbuser, dbpass);
		Statement stmt = conn.createStatement();
	
		String sql = "DELETE FROM noteTable WHERE noteOrder="+order;
		stmt.executeUpdate(sql);
	
		stmt.close();
		conn.close();
		
	} catch(SQLException e) {
		out.println(e.toString());
	}
%>
<script language=javascript>
	location.href="noteView.jsp"
</script>