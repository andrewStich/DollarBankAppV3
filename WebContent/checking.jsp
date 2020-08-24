<%@page import="com.nagazlabs.dollarbankv3.models.CheckingAccount"%>
<%@page import="com.nagazlabs.dollarbankv3.dao.impl.CheckingsDaoImpl"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.nagazlabs.dollarbankv3.models.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="com.nagazlabs.dollarbankv3.enums.AccountType"%>
<%@page import="com.nagazlabs.dollarbankv3.models.Customer"%>
<%@page import="com.nagazlabs.dollarbankv3.dao.impl.TransactionDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Savings</title>
</head>
<%
	if(session.getAttribute("customer")!=null) {
		CheckingsDaoImpl checkingAS = new CheckingsDaoImpl();
		TransactionDaoImpl transAS = new TransactionDaoImpl();
		Customer c = (Customer)session.getAttribute("customer");
		CheckingAccount acct = checkingAS.getbyCustomer(c.getId());
		List<Transaction> trans = transAS.getByCustomerAndType(c.getId(), acct.getId());
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true" />
				<div class="container" style="margin-top:75px">
					<table class="table table-borderless">
						<tr><td><%=c.getFirstName() %>'s <%=acct.getType().toString().toLowerCase() %> account</td><td>Account ID: <%=acct.getId() %></td><td>Current Balance: <%=fmt.format(acct.getBalance()) %></td></tr>
					</table>
					<div class="mx-auto">
						<form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="checkDeposit"><input class="btn btn-info" type="submit" value="Deposit">
						</form>
						<form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="checkWithdraw"><input class="btn btn-info" type="submit" value="Withdraw">
						</form>
						<form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="checkTransfer"><input class="btn btn-info" type="submit" value="Transfer">
						</form>
					</div>
					<table class="table table-borderless">
						<%
							for(int i = 0; i<trans.size();i++) {
								Transaction t = trans.get(i);
								%>
									<tr><td><%=fmt.format(t.getStartBalance()) %></td><td><%=fmt.format(t.getAmount()) %></td><td></td><td><%=fmt.format(t.getEndBalance()) %></td></tr>
								<%
							}
						%>
					</table>
				</div>
			</body>
	<% }else {
		response.sendRedirect("login.jsp");
	}
%>
</html>