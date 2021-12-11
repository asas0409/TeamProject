<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.team.dao.BoardDAO, com.team.vo.BoardVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>free board</title>
<style>
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#list td, #list th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align:center;
}
#list tr:nth-child(even){background-color: #f2f2f2;}
#list tr:hover {background-color: #ddd;}
#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #006bb3;
  color: white;
}
</style>
<script>
   //삭제하겠다고 하면 parameter로 받아온 id값을 id로 설정해서 deletepost.jsp로
   function delete_ok(id){
      var a = confirm("정말로 삭제하겠습니까?");
      if(a) location.href='deletepost.jsp?id=' + id;
   }
</script>
</head>
<body>
<h1>한동대 맛집 정보</h1>

<!-- table -->
<table id="list" width="90%">
<!-- 한 행 생성 -->
<tr>
   <!-- table head -->
   <th>번호</th>
   <th>카테고리</th>
   <th>상호명</th>
   <th>작성자</th>
   <th>작성일</th>
   <th>방문일</th>
   <th>평점</th>
   <th>내용</th>
   <th>Edit</th>
   <th>Delete</th>
</tr>
<!-- 변수명을 u로 해서 list에 있는 <BoardVO> 객체들을 하나씩 처리 -->
<c:forEach items="${list}" var="u">
   <tr>
      <td>${u.getId()}</td>
      <td>${u.getCategory()}</td>
      <td>${u.getName()}</td>
      <td>${u.getWriter()}</td>
      <td>${u.getWritedate()}</td>
      <td>${u.getVisitdate()}</td>
      <td>${u.getScore()}</td>
      <td>${u.getContent()}</td>
      <td><a href="editform/${u.getId()}">Edit</a></td>
      <td><a href="deletepost/${u.getId()}">Delete</a></td>
   </tr>
</c:forEach>
</table>

<br/><a href="add">Add New Post</a>
</body>
</html>