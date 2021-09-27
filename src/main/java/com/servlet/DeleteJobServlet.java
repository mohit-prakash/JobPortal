package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;

/**
 * Servlet implementation class DeleteJobServlet
 */
public class DeleteJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			JobDAO dao=new JobDAO(DBConnect.getConn());
			boolean f=dao.deleteJob(id);
			
			HttpSession session = request.getSession();
			
			if(f)
			{
				session.setAttribute("succMsg", "Job Deleted Successfully!!");
				response.sendRedirect("view_job.jsp");
			}
			else
			{
				session.setAttribute("succMsg", "Something Wrong Happen!!");
				response.sendRedirect("view_job.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
