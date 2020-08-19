<%@page import="com.nagazlabs.dollarbankv3.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
</head>
<%
	if(session.getAttribute("customer") != null) {
		Customer c = (Customer) session.getAttribute("customer");
		String name = new String(c.getFirstName() + " " + c.getLastName());
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true"/>
				<div class="mx-auto container">
					<h2 class="mx-auto">Welcome <%=name%></h2>
				</div>
			</body>	
	<%
	} else {
	 	response.sendRedirect("login.jsp");
	}
%>
</html>