<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<script language = "javascript">
    function writeCheck() {
    	var form = document.writeform;
    	if (!form.date.value && !form.description.value) {
    		alert("��ĭ�� ä�� �ּ���");
    		form.date.focus();
    		return;
    	}
    	if (!form.description.value) {
    		alert("������ �Է��� �ּ���");
    		form.date.focus();
    		return;
    	}
    	form.submit();
    }
</script>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��Ʈ</title>
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
		<h2>��Ʈ</h2>
	</article>
	<article>
		<form name=writeform method=post action="noteAddProcess.jsp">
			<table width="100%" cellpadding"0" cellspacing="0" border="0">
				<tr style="background:url('img/table_mid.gif') repeat-x; text-aline:center;">
					<td width="5"> <img src="img/table_left.gif" width="5" height="30" /> </td>
					<td>�۾���</td>
					<td width="5"> <img src="img/table_right.gif" width="5" height="30" /> </td>
				</tr>
			</table>
			<table>
				<tr>
					<td align="center">����</td>
					<td> <textarea name="description" cols="50" rows="13"></textarea> </td>
				</tr>
				<tr height="1" bgcolor="#dddddd">
					<td colspan="2"> </td>
				</tr>
				<tr height="1" bgcolor="#82B5DF">
					<td colspan="2"> </td>
				</tr>
				<tr align="center">
					<td colspan="2"> <input type="button" value="�Է�" OnClick="javascript:writeCheck();"> </td>
				</tr>
			</table>
		</form>
	</article>
	</section>
</body>
</html>