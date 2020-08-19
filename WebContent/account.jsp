<%@page import="com.nagazlabs.dollarbankv3.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Settings</title>
</head>
<%
	if(session.getAttribute("customer")!=null) {
		Customer c = (Customer)session.getAttribute("customer");
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true" />
				<div class="container" style="margin-top:75px">
					<form method="post" action="./UserEdit">
						<table class="table table-borderless">
							<tr><td>First Name</td><td><input type="text" name="firstName" value="<%=c.getFirstName() %>" required></td></tr>
							<tr><td>Last Name</td><td><input type="text" name="lastName" value="<%=c.getLastName() %>" required></td></tr>
							<tr><td>User Name</td><td><input type="text" name="username" value="<%=c.getUserName() %>" required></td></tr>
							<tr><td>Password</td><td><input type="password" min="8" pattern="^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" name="password" value="<%=c.getPassword() %>" required></td></tr>
							<tr><td>Country</td><td><input type="email" name="email" value="<%=c.getEmail() %>" required></td></tr>
							<tr><td></td><td><input class="btn btn-info" type="submit" value="Edit"></td></tr>
						</table>
					</form>
				</div>
			</body>
		<%
	} else {
		response.sendRedirect("login.jsp");
	}
%>
</html>