package com.nagazlabs.dollarbankv3.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagazlabs.dollarbankv3.dao.impl.CustomerDaoImpl;
import com.nagazlabs.dollarbankv3.models.Customer;

/**
 * Servlet implementation class CustomerEdit
 */
@WebServlet("/CustomerEdit")
public class CustomerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = (Customer) request.getSession().getAttribute("customer");
		
		CustomerDaoImpl cs = new CustomerDaoImpl();
		c.setFirstName(request.getParameter("firstName"));
		c.setLastName(request.getParameter("lastName"));
		c.setUserName(request.getParameter("userName"));
		c.setPassword(request.getParameter("password"));
		c.setEmail(request.getParameter("email"));
		cs.update(c);
		c = cs.getById(c.getId());
		request.getSession().setAttribute("customer", c);
		
		response.sendRedirect("account.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
