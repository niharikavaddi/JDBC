<%@page import="javax.websocket.Session"%>
<%@page import="com.service.UserCrudImpl"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.swing.text.Document"%>
<%@page import="com.model.User"%>
<%@page import="com.service.UserCrud"%>
<%@page import="com.service.UserCrudImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style type="text/css">
body {
	background: white;
	font: bold;
	font-size: larger;
	text-align: justify;
}
</style>
</head>
<body>
	<%
		String str = (String) request.getParameter("radios");
	session.setAttribute("choice", str);
	%>
	<%
		try {
		if (str.equals("2")) {
			User user = new User();
			user.setUserName((String) request.getParameter("username"));
			user.setPassword((String) request.getParameter("password"));
			UserCrud userCrud = new UserCrudImpl();
			if (userCrud.readUser(user.getUserName()) != null) {
		session.setAttribute("oldusername", (String) request.getParameter("username"));
		session.setAttribute("oldpassword", (String) request.getParameter("password"));
	%>
	<form action="SecondServlet" method="post">
		Enter new user name:<input type="text" name="username"> Enter
		new password:<input type="password" name="password"> <input
			type="submit" value="submit">
	</form>
	<%
		} else {
	out.print("Username doesn't exist");
	}
	} else {
	RequestDispatcher dispatcher = request.getRequestDispatcher("SecondServlet");
	dispatcher.forward(request, response);
	}
	} catch (Exception e) {
	out.print(e.getMessage());
	}
	%>
</body>
</html>

