package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Movie_Bean;
import com.reposity.Movie_Reposity;

/**
 * Servlet implementation class Movie_List_Servlet
 */
@WebServlet("/Movie_List_Servlet")
public class Movie_List_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movie_List_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String catId = request.getParameter("catId");
	if (catId != null) {
		int id = Integer.parseInt(catId);
		Movie_Reposity movRepo = new Movie_Reposity();
		List<Movie_Bean> movList = movRepo.getMovesByCatId(id);
		
		request.setAttribute("mov_List", movList);
		request.getRequestDispatcher("movList.jsp").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
