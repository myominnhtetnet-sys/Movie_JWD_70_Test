package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reposity.Movie_Reposity;

/**
 * Servlet implementation class Selected_Servlet
 */
@WebServlet("/Selected_Servlet")
public class Selected_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selected_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] movs = request.getParameterValues("manme");
		if (movs != null) {
			int movId = Integer.parseInt(movs[0]);
			Movie_Reposity movRepo = new Movie_Reposity();
			int i = movRepo.rentMovi(1, movId);
			if (i!=0) {
				response.sendRedirect("welcome.jsp");
			} else {
				
			}
		}
	}

}
