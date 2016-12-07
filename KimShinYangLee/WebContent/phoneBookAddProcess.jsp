<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
	request.setCharacterEncoding("euc-kr");
	
	Class.forName("com.mysql.jdbc.Driver");
	
	String url = "jdbc:mysql://127.0.0.1:3306/swproject?useSSL=false";
	String dbuser = "swproject";
	String dbpass = "12345";
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