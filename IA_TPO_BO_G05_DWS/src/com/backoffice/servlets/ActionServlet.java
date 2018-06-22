package com.backoffice.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backoffice.beans.LogsBeanRemote;
import com.backoffice.beans.ServiciosBeanRemote;
import com.backoffice.beans.SolicitudesBeanRemote;
import com.backoffice.beans.TiposServicioBeanRemote;
import com.backoffice.dto.LogDTO;
import com.backoffice.dto.ServicioDTO;
import com.backoffice.dto.SolicitudDTO;
import com.backoffice.dto.TipoServicioDTO;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private SolicitudesBeanRemote solicitudesBean;
	@EJB
    private ServiciosBeanRemote serviciosBean;
	@EJB
    private TiposServicioBeanRemote tiposServicioBean;
	@EJB
    private LogsBeanRemote logsBean;
	
	//private ObjectMapper objectMapper;
	
	@Override
	public void init() throws ServletException {
		super.init();
		//objectMapper = new ObjectMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String action = request.getParameter("action");
		String jspPage = "/404.jsp";
		
		if (action.isEmpty()) {
			
		} else if (action.equals("VerSolicitudes")) {
			jspPage = verSolicitudes(request, response);	
		} else if (action.equals("AprobarSolicitud")) {
			solicitudesBean.aprobar(Integer.valueOf(request.getParameter("idSolicitud")));
			jspPage = verSolicitudes(request, response);
		} else if (action.equals("DesaprobarSolicitud")) {
			solicitudesBean.desaprobar(Integer.valueOf(request.getParameter("idSolicitud")));
			jspPage = verSolicitudes(request, response);
		} else if (action.equals("VerServicios")) {
			jspPage = verServicios(request, response);
		} else if (action.equals("VerTiposDeServicio")) {
			jspPage = verTiposServicio(request, response);
		} else if (action.equals("VerLogs")) {
			jspPage = verLogs(request, response);
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
	
	private String verSolicitudes (HttpServletRequest request, HttpServletResponse response) {
		List<SolicitudDTO> solicitudes = new ArrayList<>();
		solicitudes = solicitudesBean.getAll();
    	request.setAttribute("solicitudes", solicitudes);
    	return "/solicitudes.jsp";
	}
	
	private String verServicios (HttpServletRequest request, HttpServletResponse response) {
		List<ServicioDTO> servicios = new ArrayList<>();
		List<TipoServicioDTO> tiposservicio = new ArrayList<>();
		servicios = serviciosBean.getAll();
		tiposservicio = tiposServicioBean.getAll();
    	request.setAttribute("servicios", servicios);
    	request.setAttribute("tiposservicio", tiposservicio);
    	return "/servicios.jsp";
	}
	
	private String verTiposServicio (HttpServletRequest request, HttpServletResponse response) {
		List<TipoServicioDTO> tiposservicio = new ArrayList<>();
		tiposservicio = tiposServicioBean.getAll();
    	request.setAttribute("tiposservicio", tiposservicio);
    	return "/tiposservicio.jsp";
	}
	
	private String verLogs (HttpServletRequest request, HttpServletResponse response) {
		List<LogDTO> logs = new ArrayList<>();
		logs = logsBean.getAll();
    	request.setAttribute("logs", logs);
    	return "/logs.jsp";
	}

}
