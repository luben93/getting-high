<%@page import="BO.Fasade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList" %>
<%@page import="DB.Item" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>

 <img src="cart.jpg" alt="Problem loading picture" style="width:300px;height:228px">

<%
//iterating over all item to add some of them
String cat="cat1";
Fasade fasad =(Fasade)session.getAttribute("fasad");
for(int i=0;i<Fasade.getItemList(cat).size();i++){
	//System.out.println("hej"+i+" "+Fasade.getItemList(cat).size());
	if("on".equals(request.getParameter(Fasade.getItemList(cat).get(i).getName()))){
		fasad.addItemToCart(Fasade.getItemList(cat).get(i));
	}
}


%>

<FORM ACTION="Buy.jsp">
<%//list all items and go to pay
ArrayList<Item> list=fasad.getCart();
for(int i = 0; i < list.size(); i++) {

   %>
name: <%= list.get(i).getName() %> 
price: <%= list.get(i).getPrice() %> 
inStore: <%= list.get(i).getSaldo() %> 

<BR>

<% } %>
<input type="Submit" value="Buy All">

</FORM>
<form action="logout.jsp">
<input type="Submit" value="logout">
</form>
</body>
</html>