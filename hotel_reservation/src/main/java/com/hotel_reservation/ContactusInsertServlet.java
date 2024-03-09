package com.hotel_reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactusInsertServlet")
public class ContactusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");

		

		
		boolean isTrue;
		
		isTrue =ContactusDBUtil.insert(name, email, phone, message);
	
		if(isTrue == true) {
			
			List<Contactus> ContactusDetails = ContactusDBUtil.view(name);
			request.setAttribute("ContactusDetails",ContactusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("ViewContact.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<Contactus> ContactusDetails = ContactusDBUtil.view(name);
			request.setAttribute("ContactusDetails",ContactusDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccesstohome.jsp");
			dis2.forward(request, response);
		}
	}

}
