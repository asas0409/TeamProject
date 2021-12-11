<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addok" method="post">
<table>
<tr><td>카테고리:</td><td><input type="text" name="category"/></td></tr>
<tr><td>상호명:</td><td><input type="text" name="name"/></td></tr>
<tr><td>작성자:</td><td><input type="text" name="writer"/></td></tr>
<tr><td>방문일:</td><td><input type="date" name="visitdate"/></td></tr>
<tr><td>평점:</td><td><input type="text" name="score"/></td></tr>
<tr><td>내용:</td><td><textarea cols="50" rows="5" name="content"></textarea></td></tr>
<tr><td>비밀번호:</td><td><input type="password" name="pw"/></td></tr>
<tr><td><a href="list">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>