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
 * Servlet implementation class UpdateJobServlet
 */
public class UpdateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String title=request.getParameter("title");
			String location=request.getParameter("location");
			String category=request.getParameter("category");
			String status=request.getParameter("status");
			String desc=request.getParameter("desc");
			
			Jobs j=new Jobs();
			j.setId(id);
			j.setCategory(category);
			j.setDescription(desc);
			j.setTitle(title);
			j.setLocation(location);
			j.setStatus(status);
			
	HttpSession session = request.getSession();
			
			JobDAO dao = new JobDAO(DBConnect.getConn());
			boolean f=dao.updateJob(j);
			if(f)
			{
				session.setAttribute("succMsg", "Job Updated Successfully!!");
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
