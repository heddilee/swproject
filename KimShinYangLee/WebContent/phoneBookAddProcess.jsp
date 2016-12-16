<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="db1.UsingDB" %>
<%
	request.setCharacterEncoding("euc-kr");
	UsingDB db = new UsingDB();
	Class.forName("com.mysql.jdbc.Driver");
	String url = db.getUrl();
	String dbuser = db.getDbuser();
	String dbpass = db.getDbpass();
	String date = request.getParameter("date");
	String description = request.getParameter("description");
	int max = 0;
	
	try {
		Connection conn = DriverManager.getConnection(url, dbuser, dbpass);
		Statement stmt = conn.createStatement();
		String sql = "SELECT MAX(scheduleOrder) FROM scheduleTable";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			max = rs.getInt(1);
		}
		sql = "INSERT INTO scheduleTable(scheduleDate, scheduleDescription, scheduleOrder) VALUES(?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, phoneName);
		pstmt.setString(2, phoneNumber);
		pstmt.setInt(3, max+1);
		pstmt.execute();
		pstmt.close();
	} catch(SQLException e) {
		out.println(e.toString());
	}
%>
<script language=javascript>
	location.href="phoneBookView.jsp"
</script>