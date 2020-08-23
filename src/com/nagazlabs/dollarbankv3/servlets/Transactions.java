package com.nagazlabs.dollarbankv3.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagazlabs.dollarbankv3.dao.impl.CheckingsDaoImpl;
import com.nagazlabs.dollarbankv3.dao.impl.SavingsDaoImpl;
import com.nagazlabs.dollarbankv3.dao.impl.TransactionDaoImpl;
import com.nagazlabs.dollarbankv3.enums.AccountType;
import com.nagazlabs.dollarbankv3.models.CheckingAccount;
import com.nagazlabs.dollarbankv3.models.CheckingTransaction;
import com.nagazlabs.dollarbankv3.models.Customer;
import com.nagazlabs.dollarbankv3.models.SavingsAccount;
import com.nagazlabs.dollarbankv3.models.SavingsTransaction;
import com.nagazlabs.dollarbankv3.models.abstracts.Transaction;

/**
 * Servlet implementation class Transactions
 */
@WebServlet("/Transactions")
public class Transactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String send = new String("checking.jsp");
		Customer c = (Customer) request.getSession().getAttribute("customer");
		Transaction t;
		CheckingAccount tempChecking;
		SavingsAccount tempSavings;
		TransactionDaoImpl ts = new TransactionDaoImpl();
		CheckingsDaoImpl checkingAS = new CheckingsDaoImpl();
		SavingsDaoImpl savingsAS = new SavingsDaoImpl();
		
		if(request.getParameter("saveTrans") != null) {
			t = new SavingsTransaction();
			tempSavings = savingsAS.getbyCustomerAndType(c.getId(), AccountType.SAVINGS);
			float temp = Float.valueOf(request.getParameter("saveTrans"));
			float startBalance = tempSavings.getBalance();
			float endBalance = startBalance - temp;
			
			t.setAccountId(tempSavings.getId());
			t.setCustomerId(c.getId());
			t.setAmount(-temp);
			t.setStartBalance(startBalance);
			t.setEndBalance(endBalance);
			tempSavings.setBalance(endBalance);
			savingsAS.update(tempSavings);
			ts.create(t);
			
			t = new CheckingTransaction();
			tempChecking = checkingAS.getbyCustomerAndType(c.getId(), AccountType.CHECKING);
			startBalance = tempChecking.getBalance();
			endBalance = startBalance + temp;
			
			t.setAccountId(tempChecking.getId());
			t.setCustomerId(c.getId());
			t.setAmount(temp);
			t.setStartBalance(startBalance);
			t.setEndBalance(endBalance);
			tempChecking.setBalance(endBalance);
			checkingAS.update(tempChecking);
			ts.create(t);
		}
		
		if(request.getParameter("checkTrans") != null) {
			t = new CheckingTransaction();
			tempChecking = checkingAS.getbyCustomerAndType(c.getId(), AccountType.CHECKING);
			float temp = Float.valueOf(request.getParameter("checkTrans"));
			float startBalance = tempChecking.getBalance();
			float endBalance = startBalance - temp;
			
			t.setAccountId(tempChecking.getId());
			t.setCustomerId(c.getId());
			t.setAmount(-temp);
			t.setStartBalance(startBalance);
			t.setEndBalance(endBalance);
			tempChecking.setBalance(endBalance);
			checkingAS.update(tempChecking);
			ts.create(t);
			
			t = new SavingsTransaction();
			tempSavings = savingsAS.getbyCustomerAndType(c.getId(), AccountType.SAVINGS);
			startBalance = tempSavings.getBalance();
			endBalance = startBalance + temp;
			
			t.setAccountId(tempSavings.getId());
			t.setCustomerId(c.getId());
			t.setAmount(temp);
			t.setStartBalance(startBalance);
			t.setEndBalance(endBalance);
			tempSavings.setBalance(endBalance);
			savingsAS.update(tempSavings);
			ts.create(t);
		}
		
		if(request.getParameter("saveWithdraw") != null) {
			t = new SavingsTransaction();
			tempSavings = savingsAS.getbyCustomerAndType(c.getId(), AccountType.SAVINGS);
			float temp = Float.valueOf(request.getParameter("saveWithdraw"));
			float startBalance = tempSavings.getBalance();
			float endBalance = startBalance - temp;
			
			t.setAccountId(tempSavings.getId());
			t.setCustomerId(c.getId());
			t.setAmount(-temp);
			t.setStartBalance(startBalance);
			t.setEndBalance(endBalance);
			tempSavings.setBalance(endBalance);
			savingsAS.update(tempSavings);
			ts.create(t);
			send = new String("savings.jsp");
		}
		
		if(request.getParameter("checkWithdraw") != null) {
			t = new CheckingTransaction();
			tempChecking = checkingAS.getbyCustomerAndType(c.getId(), AccountType.CHECKING);
			float temp = Float.valueOf(request.getParameter("checkWithdraw"));
			float startBalance = tempChecking.getBalance();
			float endBalance = startBalance - temp;
			
			t.setAccountId(tempChecking.getId());
			t.setCustomerId(c.getId());
			t.setAmount(-temp);
			t.setStartBalance(startBalance);
			t.setEndBalance(endBalance);
			tempChecking.setBalance(endBalance);
			checkingAS.update(tempChecking);
			ts.create(t);
		}
		
		if(request.getParameter("saveDeposit") != null) {
			t = new SavingsTransaction();
			tempSavings = savingsAS.getbyCustomerAndType(c.getId(), AccountType.SAVINGS);
			float temp = Float.valueOf(request.getParameter("saveDeposit"));
			float startBalance = tempSavings.getBalance();
			float endBalance = startBalance + temp;
			
			t.setAccountId(tempSavings.getId());
			t.setCustomerId(c.getId());
			t.setAmount(temp);
			t.setStartBalance(startBalance);
			t.setEndBalance(endBalance);
			tempSavings.setBalance(endBalance);
			savingsAS.update(tempSavings);
			ts.create(t);
			send = new String("savings.jsp");
		}
		
		if(request.getParameter("checkDeposit") != null) {
			t = new CheckingTransaction();
			tempChecking = checkingAS.getbyCustomerAndType(c.getId(), AccountType.CHECKING);
			float temp = Float.valueOf(request.getParameter("checkDeposit"));
			float startBalance = tempChecking.getBalance();
			float endBalance = startBalance + temp;
			
			t.setAccountId(tempChecking.getId());
			t.setCustomerId(c.getId());
			t.setAmount(temp);
			t.setStartBalance(startBalance);
			t.setEndBalance(endBalance);
			tempChecking.setBalance(endBalance);
			checkingAS.update(tempChecking);
			ts.create(t);
		}
		
		response.sendRedirect(send);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
