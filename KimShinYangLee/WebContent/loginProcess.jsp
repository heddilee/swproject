<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page language="java" import="java.sql.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%//aaaa %>
  
   <header id="header">
      <a href="index.jsp"><img src="cscommu.jpg" alt=""></a>
      <div class="side">
         <form action="team.html" method="get" class="search">
            <input type="text" name="is_keyword" value="" required
               placeholder="검색" title="검색" /> <input type="submit" value="검색" />
         </form>
      </div>
      <nav id="gnb">
         <ul>

            <li class="menuLi"><a class="menuLink" href="./scheduleView.jsp">스케쥴</a>
               </li>

            <li class="menuLi"><a class="menuLink" href="./phoneBookView.jsp">전화번호부</a>
               </li>

            <li class="menuLi"><a class="menuLink" href="./noteView.jsp">노트</a>
               </li>
         </ul>
      </nav>
   </header>
   
      <div id="login">
         <aside id="login_aside">

<form action="loginProcess.jsp" method="post">
            <table border="0" cellpadding="0" cellspacing="0" width="200">
               
               <tr>
                  <td><input type="text" name="id" size="15" placeholder="아이디"
                     style="padding: 3px" value=<%
      if(id!=null){ // ID있으면 %>
                     <%=id%> <%//입력창에 뿌려줌 %> 
                     <%} else {//없다면dfsafsfd %> 
                     <%="" %>
                     <%//아무것도 표시하지 않음 %> 
                     <%} %> 
                     ></td>

                  <td rowspan="2"><input type="submit" value="로그인"
                     style="height: 50px" />
                  <td />
               <tr>
                  <td><input type="password" name="password" size="15"
                     placeholder="비밀번호" style="padding: 3px" /></td>
              
               
            </table>
            </form>
            
         </aside>
      </div>
</body>
</html>