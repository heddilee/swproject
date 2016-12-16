<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*, java.text.SimpleDateFormat, java.util.Date" %>
<%@ page import="db1.UsingDB" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전화번호부</title>
</head>
<body>
	<header id = "header">
		<a href = "../main.jsp"><img src="../나중에 이미지파일이름.jpg" alt=""></a>
		<nav id = "nav">
			<ul>
				<li> <a class="menuLink" href="phoneBookVeiw.jsp">전화번호부</a> </li>
				<li> <a class="menuLink" href="scheduleVeiw.jsp">스케쥴</a> </li>
				<li> <a class="menuLink" href="noteVeiw.jsp">노트</a> </li>
			</ul>
		</nav>
	</header>
	<section id = "main_section">
	<article class = "menu_title">
		<h2>전화번호부</h2>
	</article>

<%
	String sessionId = (String) session.getAttribute("id");
	if (sessionId == null) {
		%><script>
		window.alert("로그인 하세요.");
		location.href = "../main.jsp";
		</script><%
	}
	
	UsingDB db = new UsingDB();
	Class.forName("com.mysql.jdbc.Driver");
	String url = db.getUrl();
	String dbuser = db.getDbuser();
	String dbpass = db.getDbpass();
	
	try {
		Connection conn = DriverManager.getConnection(url, dbuser, dbpass);
		Statement stmt = conn.createStatement();
	%>
	<article>
		<%
		String sqlList = "SELECT scheduleDate, scheduleDescription, scheduleOrder from scheduleTable";
		ResultSet rs = stmt.executeQuery(sqlList);
		%>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr style="background:url('img/table_mid.gif')" repear-x; text-align:center;">
				<!-- url부분 만들어서 img폴더에 넣어야 함 -->
				<td width = "150">이름</td>
				<td width = "150">전화번호</td>
				<td width = "150"></td>
			</tr>
		<%
		while (rs.next()) {
			String phoneName = rs.getString(1);
			String phoneNumber = rs.getString(2);
			int order = rs.getInt(3);
		%>
			<tr height="25" align="center">
				<td><%=phoneName %></td>
				<td><%=phoneNumber %></td>
				<td><a href="../phoneDeleteProcess.jsp?order=<%=order %>"><img src="../나중에 이미지파일이름.jpg" alt=""></a></td>
			</tr>
			<tr height="1" bgcolor = "#D2D2D2">
				<td colspan="3"></td>
			</tr>
		</table>
	</article>
	</section>
	<%
		}
		rs.close();
		stmt.close();
		conn.close();
	}
	catch(SQLException e) {
		out.println(e.toString());
	}
	%>
</body>
</html>