<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>new user</title>
</head>
<body>
<FORM METHOD=POST ACTION="startPage.jsp">
<%=session.getAttribute("already") %><BR>
Enter Username <INPUT TYPE=TEXT NAME=newusername SIZE=20><BR>
Enter Password <INPUT TYPE="password" NAME=newpassword SIZE=20><BR>

<P><INPUT TYPE=SUBMIT>
</FORM>
 
</body>
</html>