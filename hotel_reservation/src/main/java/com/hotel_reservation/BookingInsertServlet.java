package com.hotel_reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingInsertServlet")
public class BookingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String packages = request.getParameter("packages");
		String arrival = request.getParameter("arrival");
		String depature = request.getParameter("depature");

		

		
		boolean isTrue;
		
		isTrue =BookingDBUtil.insert(name, packages, arrival, depature);
	
		if(isTrue == true) {
			
			List<Booking> BookingDetails = BookingDBUtil.view(name);
			request.setAttribute("BookingDetails",BookingDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("ViewBook.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<Booking> BookingDetails = BookingDBUtil.view(name);
			request.setAttribute("BookingDetails",BookingDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccesstohome.jsp");
			dis2.forward(request, response);
		}
	}

}
