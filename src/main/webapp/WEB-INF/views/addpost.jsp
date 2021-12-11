<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.team.dao.BoardDAO"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="u" class="com.team.vo.BoardVO" />
<jsp:setProperty property="*" name="u"/>

<%
   BoardDAO boardDAO = new BoardDAO();
   int i = boardDAO.insertBoard(u);
   String msg = "데이터 추가에 성공했습니다.";
   System.out.println(u.getContent());
   if(i == 0) msg = "[에러] 데이터 추가 ";
%>

<script>
   alert('<%=msg%>');   
   location.href='posts.jsp';
</script>