package com.hotel_reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email= request.getParameter("email");
		String phone = request.getParameter("phone");

		
		boolean isTrue;
		
		isTrue =CustomerDBUtil.update(id, firstname, lastname, email, phone);
	
		if(isTrue == true) {
			
			List<Customer> CustomerDetails = CustomerDBUtil.view(id);
			request.setAttribute("CustomerDetails",CustomerDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("Account.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<Customer> CustomerDetails = CustomerDBUtil.view(id);
			request.setAttribute("CustomerDetails",CustomerDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccesstohome.jsp");
			dis2.forward(request, response);
		}
	}

	}


