<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
  <h2>로그인 페이지</h2>
  <%
    session.removeAttribute("userid");
    session.removeAttribute("password");
  %>
  
  <form action="/Homepage/login_auth.do" method="post">
    <p>아이디</p><input type = "text" name="userid" placeholder="아이디">
    <p>비밀번호</p><input type = "password" name="password" placeholder="비밀번호"><br>
    <input type="submit" value="로그인">
  </form>
  <form action="member_register.jsp">
    <input type="submit" value="회원가입">
  </form>
</body>
</html>