<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>
</head>
<body>
  <%
    String userid = (String) session.getAttribute("userid");
  %>

  <h2>로그인 결과 페이지</h2>
  <p><%=userid %>님, 환영합니다.!</p>
  <a href="/Homepage/select.do?userid=<%=userid %>"><input type="button" value="회원정보"></a>
  <a href="login.jsp"><input type="button" value="로그아웃"></a>
</body>
</html>