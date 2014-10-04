<!DOCTYPE html>
<%@page import="java.util.ArrayList" %>
<%@page import="BO.Fasade" %>
<%@page import="DB.Item" %>
<HTML>
<BODY>
<%
ArrayList<Item> list=Fasade.getItemList("cat1");

%>
Logged in as: <%= session.getAttribute( "username" ) %>
<FORM ACTION="cart.jsp">
<%  for(int i = 0; i < list.size(); i++) {
          
	String desc = "desc:";
	if(list.get(i).getDesc()!=null){
		desc = "desc: "+list.get(i).getDesc();
	}else{
		desc="";
	}

   %>
name: <%= list.get(i).getName() %> 
<%= desc %> 
price: <%= list.get(i).getPrice() %> 
inStore: <%= list.get(i).getSaldo() %> 

<input type="checkbox" name="<%=list.get(i).getName() %>" >
<BR>

<% } %>
<input type="Submit" value="add to cart">

</FORM>
<form action="logout.jsp">
<input type="Submit" value="logout">
</form>
</BODY>
</HTML>
