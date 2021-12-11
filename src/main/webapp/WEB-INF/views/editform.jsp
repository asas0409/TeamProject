<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.team.dao.BoardDAO, com.team.vo.BoardVO"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<form:form commandName="boardVO" method="GET" action="../editok">
   <form:hidden path="id"/>
   <table id="edit">
      <tr><td>카테고리:</td><td><input type="text" name="category"/></td></tr>
      <tr><td>상호명:</td><td><input type="text" name="name"/></td></tr>
      <tr><td>작성자:</td><td><input type="text" name="writer"/></td></tr>
      <tr><td>방문일:</td><td><input type="date" name="visitdate"/></td></tr>
      <tr><td>평점:</td><td><input type="text" name="score"/></td></tr>
      <tr><td>내용:</td><td><textarea cols="50" rows="5" name="content"></textarea></td></tr>
   </table>
   <input type="submit" value="수정하기"/>
   <input type="button" value="취소하기" onclick="history.back()"/>
</form:form>

</body>
</html>