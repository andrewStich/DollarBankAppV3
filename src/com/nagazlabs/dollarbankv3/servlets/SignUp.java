package com.nagazlabs.dollarbankv3.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagazlabs.dollarbankv3.dao.impl.CheckingsDaoImpl;
import com.nagazlabs.dollarbankv3.dao.impl.CustomerDaoImpl;
import com.nagazlabs.dollarbankv3.dao.impl.SavingsDaoImpl;
import com.nagazlabs.dollarbankv3.dao.impl.TransactionDaoImpl;
import com.nagazlabs.dollarbankv3.models.CheckingAccount;
import com.nagazlabs.dollarbankv3.models.CheckingTransaction;
import com.nagazlabs.dollarbankv3.models.Customer;
import com.nagazlabs.dollarbankv3.models.SavingsAccount;
import com.nagazlabs.dollarbankv3.models.SavingsTransaction;
import com.nagazlabs.dollarbankv3.models.abstracts.Transaction;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String send = new String("login.jsp");
		CheckingsDaoImpl checkingAS = new CheckingsDaoImpl();
		SavingsDaoImpl savingsAS = new SavingsDaoImpl();
		TransactionDaoImpl ts = new TransactionDaoImpl();
		CustomerDaoImpl cs = new CustomerDaoImpl();
		
		if(cs.getByUserName(request.getParameter("userName")) != null ) {
			request.getSession().invalidate();
			request.getSession(true);
			request.getSession().setAttribute("accountExists", true);
			send = new String("signup.jsp");
			response.sendRedirect(send);
		}
		
		Customer c = new Customer();
		c.setFirstName(request.getParameter("firstName"));
		c.setLastName(request.getParameter("lastName"));
		c.setUserName(request.getParameter("userName"));
		c.setPassword(request.getParameter("pass1"));
		c.setEmail(request.getParameter("email"));
		System.out.println(c.toString());
		cs.create(c);
		c = cs.getByUserName(c.getUserName());
		
		CheckingAccount a = new CheckingAccount();
		a.setCustomerId(c.getId());
		a.setBalance(Float.valueOf(request.getParameter("balance")));
		System.out.println(a.toString());
		checkingAS.create(a);
		
		Transaction t = new CheckingTransaction();
		t.setCustomerId(c.getId());
		t.setAccountId(a.getId());
		t.setStartBalance(0.0f);
		t.setAmount(a.getBalance());
		t.setEndBalance(a.getBalance());
		System.out.println(t.toString());
		ts.create(t);
		
		SavingsAccount a2 = new SavingsAccount();
		a2.setCustomerId(c.getId());
		a2.setBalance(0.0f);
		System.out.println(a2.toString());
		savingsAS.create(a2);
		
		t = new SavingsTransaction();
		t.setCustomerId(c.getId());
		t.setAccountId(a2.getId());
		t.setStartBalance(0.0f);
		t.setAmount(a2.getBalance());
		t.setEndBalance(a2.getBalance());
		System.out.println(t.toString());
		ts.create(t);
		
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
