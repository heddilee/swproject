<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*, java.text.SimpleDateFormat, java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������</title>
</head>
<body>
	<header id = "header">
		<a href = "../main.jsp"><img src="../���߿� �̹��������̸�.jpg" alt=""></a>
		<nav id = "nav">
			<ul>
				<li> <a class="menuLink" href="phoneBookVeiw.jsp">��ȭ��ȣ��</a> </li>
				<li> <a class="menuLink" href="scheduleVeiw.jsp">������</a> </li>
				<li> <a class="menuLink" href="noteVeiw.jsp">��Ʈ</a> </li>
			</ul>
		</nav>
	</header>
	<section id = "main_section">
	<article class = "menu_title">
		<h2>������</h2>
	</article>

<%
	String sessionId = (String) session.getAttribute("id");

	if (sessionId != null) {
		%><script>
		window.alert("�α��� �ϼ���.");
		location.href = "../main.jsp";
		</script><%
	}
	
	usingDB db = new usingDB();
	
	Class.forName("com.mysql.jdbc.Driver");
	String url = db.url;
	String dbuser = db.dbuser;
	String dbpass = db.dbpass;
	
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
				<!-- url�κ� ���� img������ �־�� �� -->
				<td width = "150">��¥</td>
				<td width = "150">����</td>
				<td width = "150"></td>
			</tr>

		<%
		while (rs.next()) {
			String date = rs.getString(1);
			String description = rs.getString(2);
			int order = rs.getInt(3);
		%>

			<tr height="25" align="center">
				<td><%=date %></td>
				<td><%=description %></td>
				<td><a href="../scheduleDeleteProcess.jsp?order=<%=order %>"><img src="../���߿� �̹��������̸�.jpg" alt=""></a></td>
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