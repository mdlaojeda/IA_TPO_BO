package com.backoffice.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.backoffice.dto.*;
import com.backoffice.excepciones.LogException;
import com.backoffice.excepciones.ServicioException;
import com.backoffice.excepciones.SolicitudException;
import com.backoffice.excepciones.TipoServicioException;
import com.backoffice.fachada.FachadaBeanRemote;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/")
public class REST {

	@EJB
	private FachadaBeanRemote fachadaBean;

	// --------- SOLICITUDES ---------//
	@PUT
	@Path("/solicitudes")
	@Consumes({ "application/json" })
	@Produces({ "text/plain" })
	public Response enviarSolicitud(String solicitudReq) {

		SolicitudDTO solicitudDTO = new SolicitudDTO();
		ObjectMapper objectMapper = new ObjectMapper();
		String codEntidad = "";
		try {
			solicitudDTO = objectMapper.readValue(solicitudReq, SolicitudDTO.class);
			codEntidad = fachadaBean.enviarSolicitud(solicitudDTO);
		} catch (SolicitudException | IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(codEntidad, MediaType.TEXT_PLAIN).build();
	}

	// --------- SERVICIOS ---------//
	@GET
	@Path("/servicios/all")
	@Produces({ "application/json" })
	public Response obtenerServicios() {
		List<ServicioDTO> resp = new ArrayList<ServicioDTO>();
		try {
			resp = fachadaBean.obtenerServicios();
		} catch (ServicioException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(resp, MediaType.APPLICATION_JSON).build();
	}

	@SuppressWarnings("deprecation")
	@GET
	@Path("/servicios")
	@Produces({ "application/json" })
	public Response obtenerServiciosPorTipo() throws ServicioException, TipoServicioException {

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayRespuesta = mapper.createArrayNode();

		try {
			List<ServicioDTO> servicios = fachadaBean.obtenerServicios();
			List<TipoServicioDTO> tiposServicio = fachadaBean.obtenerTiposServicio();

			for (TipoServicioDTO tsDTO : tiposServicio) {
				ObjectNode tsObj = mapper.createObjectNode();
				ArrayNode serviciosNode = mapper.createArrayNode();

				tsObj.put("id", tsDTO.getNroTipoServicio());
				tsObj.put("nombre", tsDTO.getDescripcion());

				for (ServicioDTO sDTO : servicios) {
					if (sDTO.getTipoServicio().getNroTipoServicio() == tsDTO.getNroTipoServicio()) {
						ObjectNode sObj = mapper.createObjectNode();
						sObj.put("id", sDTO.getNroServicio());
						sObj.put("nombre", sDTO.getDescripcion());
						serviciosNode.add(sObj);
					}
				}
				tsObj.put("servicios", serviciosNode);
				arrayRespuesta.add(tsObj);
			}
		} catch (ServicioException | TipoServicioException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.ok(arrayRespuesta, MediaType.APPLICATION_JSON).build();
	}

	// --------- LOGS ---------//
	@PUT
	@Path("/logs")
	@Consumes({ "application/json" })
	@Produces({ "text/plain" })
	public Response enviarLog(String logreq) {
		try {
			fachadaBean.enviarLog(new ObjectMapper().readValue(logreq, LogDTO.class));
		} catch (IOException | LogException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.ok("Log creado con éxito", MediaType.TEXT_PLAIN).build();
	}

}