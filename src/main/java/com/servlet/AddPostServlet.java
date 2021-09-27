package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.Jobs;

/**
 * Servlet implementation class AddPostServlet
 */
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title=request.getParameter("title");
			String location=request.getParameter("location");
			String category=request.getParameter("category");
			String status=request.getParameter("status");
			String desc=request.getParameter("desc");
			
			Jobs j = new Jobs();
			j.setCategory(category);
			j.setDescription(desc);
			j.setLocation(location);
			j.setStatus(status);
			j.setTitle(title);
			
			HttpSession session = request.getSession();
			
			JobDAO dao = new JobDAO(DBConnect.getConn());
			boolean f=dao.addJobs(j);
			if(f)
			{
				session.setAttribute("succMsg", "Job Posted Successfully!!");
				response.sendRedirect("add_job.jsp");
			}
			else
			{
				session.setAttribute("succMsg", "Something Wrong Happen!!");
				response.sendRedirect("add_job.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
