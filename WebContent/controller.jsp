<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Fasade.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>your not really here</title>
</head>
<body>

	<%
		String newN = "";
		newN = request.getParameter("newusername");
		session.setAttribute("newusername", newN);
		String newP = request.getParameter("newpassword");
		session.setAttribute("newpassword", newP);

		//provide user interaction when trying to login
		String message = "";
		session.setAttribute("message", message);
		session.setAttribute("already", "");
		if (newN == null) {
			newN = "";
		}

		if (!newN.equals("")) {

			try {
				Fasade.CreateUser U = new Fasade.CreateUser();

				U.createUser(newN, newP);
			} catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e) {
				String m = "User already exists";
				session.setAttribute("already", m);
				request.getRequestDispatcher("newUser.jsp").forward(
						request, response);
			}
			System.out.print(newN);
		}
	%>

</body>
</html>