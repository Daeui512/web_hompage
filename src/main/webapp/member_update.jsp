<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<%
  String userid = (String) session.getAttribute("userid");
%>
  <h2>회원 정보 수정</h2>
  <form action="/Homepage/update.do" method="post">
    <p>아이디</p>
    <input type="text" name="userid" readonly="readonly" value="<%=userid%>"><br>
    <p>비밀번호</p>
    <input type="text" name="password" placeholder="password"><br>
    <p>이메일</p>
    <input type="text" name="email" placeholder="email"><br>
     <p>전화번호</p>    
    <input type="text" name="phone" placeholder="전화번호"><br>
    
    <p>이메일 수신여부</p>
    <input type="radio" name="emailAgree" value="yes"> 수신동의
    <input type="radio" name="emailAgree" value="no" checked="checked"> 수신거부
    <br>
    
    <p>관심사항</p>
    <input type="checkbox" name="interest" value="it">IT/인터넷 
    <input type="checkbox" name="interest" value="sport">스포츠 
    <input type="checkbox" name="interest" value="food">음식 
    <input type="checkbox" name="interest" value="movie">영화 
    <input type="checkbox" name="interest" value="music">음악 <br>
    
    <p>자기소개</p>
    <textarea rows="20" cols="40" placeholder="자기소개(최대 100글자까지 작성가능)" name="introduce"></textarea>
    <br>
    <input type="submit" value="정보수정">
  </form>
  <a href="/Homepage/delete.do?userid=<%=userid%>"><input type="button" value="회원탈퇴"></a>
</body>
</html>