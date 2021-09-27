package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String em=request.getParameter("email");
			String ps=request.getParameter("password");
			User u = new User();
			HttpSession session = request.getSession();
			if("admin@gmail.com".equals(em) && "admin@121".equals(ps))
			{
				session.setAttribute("userobj", u);
				u.setRole("admin");
				response.sendRedirect("admin.jsp");
			}
			else
			{
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
