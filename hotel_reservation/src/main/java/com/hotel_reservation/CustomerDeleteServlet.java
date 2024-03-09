package com.hotel_reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerDeleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean isTrue;
		
		isTrue =CustomerDBUtil.delete(id);
		
if(isTrue == true) {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("Register.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<Customer> CustomerDetails = CustomerDBUtil.view(id);
			request.setAttribute("CustomerDetails",CustomerDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("Account.jsp");
			dis2.forward(request, response);
		}

	}

}
