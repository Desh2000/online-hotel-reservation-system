package com.hotel_reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackDeleteServlet")
public class FeedbackDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean isTrue;
		
		isTrue =FeedbackDBUtil.delete(id);
		
if(isTrue == true) {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("Feedback.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<Feedback> FeedbackDetails = FeedbackDBUtil.get(id);
			request.setAttribute("FeedbackDetails",FeedbackDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("ViewFeed.jsp");
			dis2.forward(request, response);
		}

	}
	}


