<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="BO.Fasade" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Fasade fasad=(Fasade)session.getAttribute("fasad");
fasad.logout();
%>
your logged out now :(
come back again
<form action="startPage.jsp">
<input type="Submit" value="back to start">
</form>
</body>
</html>