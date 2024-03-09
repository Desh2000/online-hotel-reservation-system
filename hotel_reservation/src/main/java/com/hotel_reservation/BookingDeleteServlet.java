package com.hotel_reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookingDeleteServlet")
public class BookingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Polymorphism concept
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean isTrue;
		
		isTrue =BookingDBUtil.delete(id);
		
if(isTrue == true) {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<Booking> BookingDetails = BookingDBUtil.get(id);
			request.setAttribute("BookingDetails",BookingDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("ViewBook.jsp");
			dis2.forward(request, response);
		}
	}

}
