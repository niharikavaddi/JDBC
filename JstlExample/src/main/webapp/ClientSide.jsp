<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
<style type="text/css">
body {
	background: white;
}

table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th>User name</th>
				<th>User password</th>
			</tr>
			<c:forEach items="${requestScope.users}" var="user">
				<tr>
					<td><c:out value="${user.userName}"></c:out></td>
					<td><c:out value="${user.password}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>