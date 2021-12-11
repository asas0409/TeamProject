<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.team.dao.BoardDAO, com.team.vo.BoardVO"%>
<%
   //request 객체의 id값을 받아와서 id가 empty string이 아니면 id에 해당하는 데이터를 boardDAO의 deleteBoard 함수를 이용해서 삭제
   String sid = request.getParameter("id");
   if (sid != ""){  
      int id = Integer.parseInt(sid);
      BoardDAO boardDAO = new BoardDAO();
      boardDAO.deleteBoard(id);
   }
   //posts.jsp로 돌아감
   response.sendRedirect("posts.jsp");
%>