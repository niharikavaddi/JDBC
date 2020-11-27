package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.exception.CustomException;
import com.model.User;
import com.service.UserCrud;
import com.service.UserCrudImpl;

@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		User user = null;
		UserCrud userCrud = null;
		try {
			user = new User();
			user.setUserName(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			HttpSession session = request.getSession(false);
			String choice = (String) session.getAttribute("choice");
			userCrud = new UserCrudImpl();
			switch (choice) {
			case "1":
				try {
					User result = userCrud.createUser(user);
					if (result != null)
						out.println("User Creation successfull");
					out.println("Username: " + user.getUserName());
					out.println("Password:" + user.getPassword());
				} catch (CustomException ce) {
					out.print(ce.getMessage());
				}
				break;
			case "2":
				try {
					User user1 = new User();
					User user2 = new User();
					user1.setUserName((String) session.getAttribute("oldusername"));
					user1.setPassword((String) session.getAttribute("oldpassword"));
					user2.setUserName(request.getParameter("username"));
					user2.setPassword(request.getParameter("password"));
					User result = userCrud.updateUser(user1, user2);
					if (result != null) {

						out.println("User Updation successfull");
					}
				} catch (CustomException ce) {
					out.print(ce.getMessage());
				}
				break;
			case "3":
				try {
					User result = userCrud.readUser(user.getUserName());
					if (result != null) {
						out.println("Reading user details successfull");
						out.println("User Details");
						out.println("Username: " + user.getUserName());
						out.println("Password " + user.getPassword());
					}
				} catch (CustomException ce) {
					out.print(ce.getMessage());
				}
				break;
			case "4":
				try {
					String result = userCrud.deleteUser(user);
					out.println("Username: " + user.getUserName());
					out.println("Password:" + user.getPassword());
					out.println(result);

				} catch (CustomException ce) {
					out.print(ce.getMessage());
				}
				break;
			default:
				out.println("Incorrect option");
			}

		} catch (Exception e) {
			out.print(e.getMessage());
		} finally {
			user = null;
			userCrud = null;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
