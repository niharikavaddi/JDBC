package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.User;
import com.service.UserCrud;
import com.service.UserCrudImpl;

@SuppressWarnings("serial")
public class JstlController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = null;
		UserCrud userCrud = null;
		PrintWriter out = response.getWriter();
		try {
			users = new ArrayList<User>();
			userCrud = new UserCrudImpl();
			users = userCrud.readUser();
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClientSide.jsp");
		request.setAttribute("users", users);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
