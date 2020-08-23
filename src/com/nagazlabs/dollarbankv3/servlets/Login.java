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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String send = new String("index.jsp");
		if(request.getParameter("user") != null && request.getParameter("pass") != null) {
			
			try {
				CustomerDaoImpl cs = new CustomerDaoImpl();
				Customer c = cs.getByUserName(request.getParameter("user"));
				
				if(request.getParameter("password").equals(c.getPassword())) {
					request.getSession().setAttribute("customer", c);
				} else {
					request.getSession().setAttribute("loginFailed", true);
					send = new String("login.jsp");
				}
			} catch (Exception e) {
				request.getSession().setAttribute("loginFailed", true);
				send = new String("login.jsp");
			}
			
		} else {
			request.getSession().setAttribute("loginFailed", true);
			send = new String("login.jsp");
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
