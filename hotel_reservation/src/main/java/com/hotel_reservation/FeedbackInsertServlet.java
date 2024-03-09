package com.hotel_reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackInsertServlet")
public class FeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String feedback = request.getParameter("feedback");
		

		
		boolean isTrue;
		
		isTrue =FeedbackDBUtil.insert(name, feedback);
	
		if(isTrue == true) {
			
			List<Feedback> FeedbackDetails = FeedbackDBUtil.view(name);
			request.setAttribute("FeedbackDetails",FeedbackDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("ViewFeed.jsp");
			dis.forward(request, response);
		}
		
		else {
			List<Feedback> FeedbackDetails = FeedbackDBUtil.view(name);
			request.setAttribute("FeedbackDetails",FeedbackDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccesstohome.jsp");
			dis2.forward(request, response);
		}
	}
	}


