package com.backoffice.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backoffice.actions.*;

import javax.servlet.RequestDispatcher;

@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Collection<IAction> actions = new HashSet<>();

	@Override
	public void init() throws ServletException {
		super.init();
		actions.add(new VerSolicitudes());
		//actions.add(new VerTiposDeServicio());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String action = request.getParameter("action");
		String jspPage = "/empty.jsp";

		IAction found = NotFound.NOT_FOUND_ACTION;
		for (IAction a : this.actions) {
			if (a.isValid(action)) {
				found = a;
				break;
			}
		}

		try {
			jspPage = found.doAction(request, response);
		} catch (NumberFormatException | ParseException e) {
			e.printStackTrace();
		}

		dispatch(jspPage, request, response);
	}
	
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (jsp != null) {
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			rd.forward(request, response);
		}
	}

}
