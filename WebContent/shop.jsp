<!DOCTYPE html>
<HTML>
<BODY>
<p>
Logged in as: <%= session.getAttribute( "newusername" ) %>
</p>
<p>
<FORM ACTION="cart.jsp">
Ectacy <INPUT TYPE=NUMBER NAME=E SIZE=20><BR>
Cocain <INPUT TYPE=NUMBER NAME=C SIZE=20><BR>
Pills  <INPUT TYPE=NUMBER NAME=P SIZE=20><BR>
</p>
<input type="Submit" value="Buy Drugs">
</form>
</BODY>
</HTML>
