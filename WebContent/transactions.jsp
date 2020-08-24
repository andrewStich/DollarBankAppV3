<%@page import="java.text.NumberFormat"%>
<%@page import="com.nagazlabs.dollarbankv3.models.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="com.nagazlabs.dollarbankv3.dao.impl.TransactionDaoImpl"%>
<%@page import="com.nagazlabs.dollarbankv3.models.abstracts.Account"%>
<%@page import="com.nagazlabs.dollarbankv3.models.Customer"%>
<%@page import="com.nagazlabs.dollarbankv3.dao.impl.CheckingsDaoImpl"%>
<%@page import="com.nagazlabs.dollarbankv3.dao.impl.SavingsDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
</head>
<%
	if(session.getAttribute("customer")!=null) {
		CheckingsDaoImpl checkingAS = new CheckingsDaoImpl();
		SavingsDaoImpl savingsAS = new SavingsDaoImpl();
		Customer c = (Customer)session.getAttribute("customer");
		Account checkAcc = checkingAS.getById(c.getId());
		Account saveAcc = savingsAS.getById(c.getId());
		TransactionDaoImpl trans = new TransactionDaoImpl();
		List<Transaction> transactions = trans.getAllByByCustomer(c.getId());
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true" />
				<div class="container" style="margin-top:75px">
					<form method="post" action="./Transactions">
						<h3 class="mx-auto"><%=c.getFirstName()+" "+c.getLastName() %> Transactions</h3>
						<table class="table table-borderless">
							<% if(request.getParameter("checkDeposit")!=null) {
								%>
								<tr>
									<td>Checking Deposit</td><td>Current Balance: <%=fmt.format(checkAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" name="checkDeposit" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Deposit"></td>
								</tr>
								<%
							} else if(request.getParameter("saveDeposit")!=null) {
								%>
								<tr>
									<td>Savings Deposit</td><td>Current Balance: <%=fmt.format(saveAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" name="saveDeposit" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Deposit"></td>
								</tr>
								<%
							} else if(request.getParameter("checkWithdrawal")!=null) {
								%>
								<tr>
									<td>Checking Withdrawal</td><td>Current Balance: <%=fmt.format(checkAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=checkAcc.getBalance() %>" name="checkWithdraw" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Withdraw"></td>
								</tr>
								<%
							} else if(request.getParameter("saveWithdrawal")!=null) {
								%>
								<tr>
									<td>Savings Withdrawal</td><td>Current Balance: <%=fmt.format(saveAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=saveAcc.getBalance() %>" name="saveWithdraw" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Withdraw"></td>
								</tr>
								<%
							} else if(request.getParameter("checkTransfer")!=null) {
								%>
								<tr>
									<td>Savings Withdrawal</td><td>Current Balance: <%=fmt.format(saveAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=saveAcc.getBalance() %>" name="checkTrans" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Transfer"></td>
								</tr>
								<%
							} else if(request.getParameter("saveTransfer")!=null) {
								%>
								<tr>
									<td>Savings Withdrawal</td><td>Current Balance: <%=fmt.format(saveAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=saveAcc.getBalance() %>" name="saveTrans" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Transfer"></td>
								</tr>
								<%
							} else {
								for(int i = 0; i < transactions.size(); i++) {
									Transaction t = transactions.get(i);
							%>
								<tr><td><%=fmt.format(t.getStartBalance()) %></td><td><%=fmt.format(t.getAmount()) %></td><td><%=fmt.format(t.getEndBalance()) %></td></tr>
							<%  }
							} %>
						</table>
					</form>
				</div>
			</body>
	<% }else {
		response.sendRedirect("login.jsp");
	}
%>
</html>