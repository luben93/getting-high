<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<BODY>
  
<%
   String name = request.getParameter( "username" );
   session.setAttribute( "username", name );
   String pass = request.getParameter( "password" );
   session.setAttribute( "password", pass );
%>

<%= session.getAttribute( "username" ) %> 
<%= session.getAttribute( "password" ) %> 

<%
String str = "";
if(session.getAttribute( "username" ).equals(session.getAttribute( "newusername" )) && 
		session.getAttribute( "password" ).equals(session.getAttribute( "newpassword")))
{
	//here we should make calls to JDBC see if user exists
    request.getRequestDispatcher("shop.jsp").forward(request, response);
}
	
else 
{
	//if it didn't exist we should tell the user and return to login page
	 String message = "wrong username or/and password";
     session.setAttribute( "message", message);
     request.getRequestDispatcher("login.jsp").forward(request, response);
     
}
%>
	
 
    
</BODY>
</HTML>

 


