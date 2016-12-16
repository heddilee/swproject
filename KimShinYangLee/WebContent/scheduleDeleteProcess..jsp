<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="db1.UsingDB" %>
<%
	request.setCharacterEncoding("euc-kr");

	UsingDB db = new UsingDB();
	Class.forName("com.mysql.jdbc.Driver");
	String url = db.getUrl();
	String dbuser = db.getDbuser();
	String dbpass = db.getDbpass();
	int order = Integer.parseInt(request.getParameter("order"));

	try {
		Connection conn = DriverManager.getConnection(url, dbuser, dbpass);
		Statement stmt = conn.createStatement();
	
		String sql = "DELETE FROM scheduleTable WHERE scheduleOrder="+order;
		stmt.executeUpdate(sql);
	
		stmt.close();
		conn.close();
		
	} catch(SQLException e) {
		out.println(e.toString());
	}
%>
<script language=javascript>
	location.href="scheduleView.jsp"
</script>