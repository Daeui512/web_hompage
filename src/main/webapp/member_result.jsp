<%@page import="edu.web.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 정보</title>
</head>
<body>
  <%
    MemberVO vo = (MemberVO) request.getAttribute("result");
  %>
    <h1>회원 정보 페이지</h1>
    <p>아이디 :  <%=vo.getUserid()%></p>
    <p>비밀번호 :  <%=vo.getPassword()%></p>
    <p>이메일 :  <%=vo.getEmail()%></p>
    <p>이메일 수신여부 :  <%=vo.getEmailAgree()%></p>
    <p>관심사항 :  <%=vo.getInterestJoin()%></p>
    <p>전화번호 :  <%=vo.getPhone()%></p>
    <p>자기소개 :  <%=vo.getIntroduce()%></p>
    <a href="member_update.jsp"><input type="button" value="정보수정"></a>
</body>
</html>