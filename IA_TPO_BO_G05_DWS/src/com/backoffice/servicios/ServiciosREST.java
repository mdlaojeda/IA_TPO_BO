package com.backoffice.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;

import com.backoffice.dto.*;
import com.backoffice.fachada.FachadaBeanRemote;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.List;

@Stateless
@Path("/")
public class ServiciosREST {
    
	@EJB
    private FachadaBeanRemote fachadaBean;
    
	//--------- SOLICITUDES ---------//
	@PUT
	@Path("/solicitudes")
	@Consumes({ "application/json" })
	@Produces({ "text/plain" })
	public String enviarSolicitud(String solicitudReq) {
		
    	SolicitudDTO solicitudDTO = new SolicitudDTO();
    	ObjectMapper objectMapper = new ObjectMapper();
    	try {
			solicitudDTO = objectMapper.readValue(solicitudReq, SolicitudDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fachadaBean.enviarSolicitud(solicitudDTO);
	}
	
	//--------- SERVICIOS ---------//
    @GET
    @Path("/servicios/all")
    @Produces({ "application/json" })
    public List<ServicioDTO> obtenerServicios() {
    	return fachadaBean.obtenerServicios();
    }
    
    @SuppressWarnings("deprecation")
	@GET
    @Path("/servicios")
    @Produces({ "application/json" })
    public ArrayNode obtenerServiciosPorTipo() {
    	
    	List<ServicioDTO> servicios = fachadaBean.obtenerServicios();
    	List<TipoServicioDTO> tiposServicio = fachadaBean.obtenerTiposServicio();

    	ObjectMapper mapper = new ObjectMapper();
    	ArrayNode arrayRespuesta = mapper.createArrayNode();
    	
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
        
    	return arrayRespuesta;
    }
	
	
	//--------- LOGS ---------//
    @PUT
    @Path("/logs")
    @Consumes({ "application/json" })
    @Produces({ "text/plain" })
    public String enviarLog(String logreq) {
    	
    	LogDTO lDTO = new LogDTO();
    	try {
    		lDTO = new ObjectMapper().readValue(logreq, LogDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fachadaBean.enviarLog(lDTO);
    }
    
    
  //--------- UTILS ---------//
    @PUT
    @Path("/reset")
    @Produces({ "text/plain" })
    public String reset() {
		return fachadaBean.reset();
    }
    
}