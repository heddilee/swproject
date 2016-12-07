<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
	request.setCharacterEncoding("euc-kr");
	usingDB db = new usingDB();
	Class.forName("com.mysql.jdbc.Driver");
	String url = db.url;
	String dbuser = db.dbuser;
	String dbpass = db.dbpass;
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