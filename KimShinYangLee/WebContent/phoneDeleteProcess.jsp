<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
	request.setCharacterEncoding("euc-kr");

	Class.forName("com.mysql.jdbc.Driver");

	String url = "jdbc:mysql://127.0.0.1:3306/swproject?useSSL=false";
	String dbuser = "swproject";
	String dbpass = "uh129921";
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