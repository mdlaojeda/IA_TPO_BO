package com.backoffice.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import com.backoffice.enums.Accion;
import com.backoffice.enums.Modulo;
import com.backoffice.excepciones.LogException;
import com.backoffice.excepciones.ServicioException;
import com.backoffice.excepciones.SolicitudException;
import com.backoffice.excepciones.TipoServicioException;

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
	
	private ObjectMapper objectMapper;
	
	@Override
	public void init() throws ServletException {
		super.init();
		objectMapper = new ObjectMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String action = request.getParameter("action");
		String jspPage = "/404.jsp";
		
		if (!action.isEmpty()) {
			if (action.equals("VerSolicitudes")) {
				jspPage = verSolicitudes(request, response);	
			} else if (action.equals("AprobarSolicitud")) {
				try {
					solicitudesBean.aprobar(Integer.valueOf(request.getParameter("idSolicitud")));
				} catch (NumberFormatException | SolicitudException e) {
					e.printStackTrace();
				}
				jspPage = verSolicitudes(request, response);
			} else if (action.equals("DesaprobarSolicitud")) {
				try {
					solicitudesBean.desaprobar(Integer.valueOf(request.getParameter("idSolicitud")));
				} catch (NumberFormatException | SolicitudException e) {
					e.printStackTrace();
				}
				jspPage = verSolicitudes(request, response);
			} else if (action.equals("LimpiarSolicitudes")) {
				try {
					solicitudesBean.borrarSolicitudes();
					logsBean.crearLog(new LogDTO(null, new Date(), Modulo.BACK_OFFICE, Accion.LIMPIEZA_SOLICITUDES));
				} catch (NumberFormatException | SolicitudException | LogException e) {
					e.printStackTrace();
				}
				jspPage = verSolicitudes(request, response);
			} else if (action.equals("VerServicios")) {
				jspPage = verServicios(request, response);
			} else if (action.equals("AgregarServicio")) {
				ServicioDTO sDTO = new ServicioDTO();
				sDTO.setDescripcion(request.getParameter("descripcion"));
				TipoServicioDTO tsDTO = (TipoServicioDTO) objectMapper.readValue(request.getParameter("tipoServicio"), TipoServicioDTO.class);
				sDTO.setTipoServicio(tsDTO);
				try {
					serviciosBean.crearServicio(sDTO);
				} catch (ServicioException e) {
					e.printStackTrace();
				}
				jspPage = verServicios(request, response);
			} else if (action.equals("EditarServicio")) {
				ServicioDTO sDTO = new ServicioDTO();
				sDTO.setNroServicio(Integer.valueOf(request.getParameter("nroServicio")));
				sDTO.setDescripcion(request.getParameter("descripcion"));
				TipoServicioDTO tsDTO = (TipoServicioDTO) objectMapper.readValue(request.getParameter("tipoServicio"), TipoServicioDTO.class);
				sDTO.setTipoServicio(tsDTO);
				try {
					serviciosBean.editarServicio(sDTO);
				} catch (ServicioException e) {
					e.printStackTrace();
				}
				jspPage = verServicios(request, response);
			} else if (action.equals("BorrarServicio")) {
				try {
					serviciosBean.borrarServicio(Integer.valueOf(request.getParameter("nroServicio")));
				} catch (NumberFormatException | ServicioException e) {
					e.printStackTrace();
				}
				jspPage = verServicios(request, response);
			} else if (action.equals("VerTiposDeServicio")) {
				jspPage = verTiposServicio(request, response);
			} else if (action.equals("AgregarTipoDeServicio")) {
				TipoServicioDTO tsDTO = new TipoServicioDTO();
				tsDTO.setDescripcion(request.getParameter("descripcion"));
				try {
					tiposServicioBean.crearTipoDeServicio(tsDTO);
				} catch (TipoServicioException e) {
					e.printStackTrace();
				}
				jspPage = verTiposServicio(request, response);
			} else if (action.equals("EditarTipoDeServicio")) {
				TipoServicioDTO tsDTO = new TipoServicioDTO();
				tsDTO.setNroTipoServicio(Integer.valueOf(request.getParameter("nroTipoServicio")));	
				tsDTO.setDescripcion(request.getParameter("descripcion"));
				try {
					tiposServicioBean.editarTipoDeServicio(tsDTO);
				} catch (TipoServicioException e) {
					e.printStackTrace();
				}
				jspPage = verTiposServicio(request, response);
			} else if (action.equals("BorrarTipoDeServicio")) {
				try {
					tiposServicioBean.borrarTipoDeServicio(Integer.valueOf(request.getParameter("nroTipoServicio")));
				} catch (NumberFormatException | TipoServicioException e) {
					e.printStackTrace();
				}
				jspPage = verTiposServicio(request, response);
			} else if (action.equals("VerLogs")) {
				jspPage = verLogs(request, response);
			} else if (action.equals("BorrarLog")) {
				try {
					logsBean.borrar(Integer.valueOf(request.getParameter("nroLog")));
				} catch (NumberFormatException | LogException e) {
					e.printStackTrace();
				}
				jspPage = verLogs(request, response);
			} else if (action.equals("LimpiarLogs")) {
				try {
					logsBean.borrarLogs();
					logsBean.crearLog(new LogDTO(null, new Date(), Modulo.BACK_OFFICE, Accion.LIMPIEZA_LOGS));
				} catch (NumberFormatException | LogException e) {
					e.printStackTrace();
				}
				jspPage = verLogs(request, response);
			}
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
	
	private String verSolicitudes(HttpServletRequest request, HttpServletResponse response) {
		List<SolicitudDTO> solicitudes = new ArrayList<>();
		try {
			solicitudes = solicitudesBean.getAll();
		} catch (SolicitudException e) {
			e.printStackTrace();
		}
    	request.setAttribute("solicitudes", solicitudes);
    	return "/solicitudes.jsp";
	}
	
	private String verServicios(HttpServletRequest request, HttpServletResponse response) {
		List<ServicioDTO> servicios = new ArrayList<>();
		List<TipoServicioDTO> tiposservicio = new ArrayList<>();
		try {
			servicios = serviciosBean.getAll();
		} catch (ServicioException e) {
			e.printStackTrace();
		}
		try {
			tiposservicio = tiposServicioBean.getAll();
		} catch (TipoServicioException e) {
			e.printStackTrace();
		}
    	request.setAttribute("servicios", servicios);
    	request.setAttribute("tiposservicio", tiposservicio);
    	return "/servicios.jsp";
	}
	
	private String verTiposServicio(HttpServletRequest request, HttpServletResponse response) {
		List<TipoServicioDTO> tiposservicio = new ArrayList<>();
		try {
			tiposservicio = tiposServicioBean.getAll();
		} catch (TipoServicioException e) {
			e.printStackTrace();
		}
    	request.setAttribute("tiposservicio", tiposservicio);
    	return "/tiposservicio.jsp";
	}
	
	private String verLogs(HttpServletRequest request, HttpServletResponse response) {
		List<LogDTO> logs = new ArrayList<>();
		try {
			logs = logsBean.getAll();
		} catch (LogException e) {
			e.printStackTrace();
		}
    	request.setAttribute("logs", logs);
    	return "/logs.jsp";
	}

}
