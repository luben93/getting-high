<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="BO.Fasade" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- do bank stuff -->
calling your bank :)
<%
Fasade fasad=(Fasade)session.getAttribute("fasad");
fasad.doBuy(true);
%>
<form action="shop.jsp">
<input type="Submit" value="Back to Shop">
</form>



<form action="logout.jsp">
<input type="Submit" value="logout">
</form>
</body>
</html>