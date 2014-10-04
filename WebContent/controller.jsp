<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="BO.Fasade"%>
<%@page language="java" session="true" %>
<%final Fasade fasad =  new Fasade();%>
<HTML>
<BODY>

	<%
  //save login credentials
   String email = request.getParameter( "username" );
   session.setAttribute( "username", email );
   String pass = request.getParameter( "password" );
   session.setAttribute( "password", pass);
   
  
 boolean isLoggedIn = fasad.login(email,pass);
	if (isLoggedIn){
 //create a session object to CheckUser
	    	session.setAttribute( "fasad", fasad );
	    	//System.out.println(isLoggedIn);
	    	//ref to a logged in user that has the ability to buy items. 
	    	session.setAttribute( "isLoggedIn", isLoggedIn );
	    	request.getRequestDispatcher("shop.jsp").forward(request, response);
   }else{
   	//System.out.println(isLoggedIn);

	   request.getRequestDispatcher("login.jsp").forward(
				request, response);
    }
    	
%>


</BODY>
</HTML>



