package com.hotel_reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean isTrue;
		
		isTrue =CustomerDBUtil.validate(username, password);

				
if(isTrue == true) {
			
			List<Customer> CustomerDetails = CustomerDBUtil.get(username);
			request.setAttribute("CustomerDetails",CustomerDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("Account.jsp");
			dis.forward(request, response);
		}
		
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your Username or Password is incorrect');");
			out.println("location = 'Login.jsp'");
			out.println("</script>");

			
		}
			}

}
