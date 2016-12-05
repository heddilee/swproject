<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<script language = "javascript">
    function writeCheck() {
    	var form = document.writeform;
    	if (!form.phoneName.value && !form.phoneNumber.value) {
    		alert("빈칸을 채워 주세요");
    		form.phoneName.focus();
    		return;
    	}
    	if (!form.phoneName.value) {
    		alert("이름를 입력해 주세요");
    		form.phoneName.focus();
    		return;
    	}
    	if (!form.phoneNumber.value) {
    		alert("번호를 입력해 주세요");
    		form.phoneNumber.focus();
    		return;
    	}
    	form.submit();
    }
</script>
    
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
	<article>
		<form name=writeform method=post action="phoneBookAddProcess.jsp">
			<table width="100%" cellpadding"0" cellspacing="0" border="0">
				<tr style="background:url('img/table_mid.gif') repeat-x; text-aline:center;">
					<td width="5"> <img src="img/table_left.gif" width="5" height="30" /> </td>
					<td>전화번호 작성</td>
					<td width="5"> <img src="img/table_right.gif" width="5" height="30" /> </td>
				</tr>
			</table>
			<table>
				<tr>
					<td align="center">이름</td>
					<td> <input name="phoneName" type="text" size="50"> </td>					
				</tr>
				<tr height="1" bgcolor="#dddddd">
					<td colspan="2"> </td>
				</tr>
				<tr>
					<td align="center">전화번호</td>
					<td> <input name="phoneNumber" type = "text" size = "50"></td>
				</tr>
				<tr height="1" bgcolor="#dddddd">
					<td colspan="2"> </td>
				</tr>
				<tr height="1" bgcolor="#82B5DF">
					<td colspan="2"> </td>
				</tr>
				<tr align="center">
					<td colspan="2"> <input type="button" value="확인" OnClick="javascript:writeCheck();"> </td>
				</tr>
			</table>
		</form>
	</article>
	</section>
</body>
</html>