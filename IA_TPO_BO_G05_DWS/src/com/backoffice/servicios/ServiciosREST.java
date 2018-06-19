package com.backoffice.servicios;

import javax.ejb.EJB;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.backoffice.dto.LogDTO;
import com.backoffice.fachada.FachadaBeanRemote;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sun.rmi.runtime.Log;

//import com.backoffice.

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.io.IOException;

@Path("/rest")
public class ServiciosREST {
    
	@EJB
    private FachadaBeanRemote fachadaBean;
    
	@POST
	@Path("/enviarsolicitud")
	@Produces({ "text/plain" })
	public String EnviarSolicitud(String test) {
		return "Test: " + test;
	}
	
	@GET
	@Path("/servicios")
	@Produces("application/json")
	public Response getServicios() {
		
		//String json = "{ \"servicios\": [{ \"id\": 1, \"descripcion\": \"test 1\" }, { \"id\": 2, \"descripcion\": \"test 1\" } ]}";
		
		String json = "[\n" + 
				"     {\n" + 
				"       \"id\": 1,\n" + 
				"       \"nombre\": \"Transporte\",\n" + 
				"       \"servicios\": [\n" + 
				"         { \"id\": 23, \"nombre\": \"servicio de traslado\"},\n" + 
				"         { \"id\": 24, \"nombre\": \"Alquiler de auto\"}\n" + 
				"       ]\n" + 
				"     },\n" + 
				"     {\n" + 
				"       \"id\": 2,\n" + 
				"       \"nombre\": \"servicio de limpieza\",\n" + 
				"       \"servicios\": [\n" + 
				"         { \"id\": 45, \"nombre\": \"servicio diario de limpieza\" },\n" + 
				"         { \"id\": 46, \"nombre\": \"servicio de planchado\" },\n" + 
				"         { \"id\": 47, \"nombre\": \"servicio de lavanderia\" }\n" + 
				"       ]\n" + 
				"     }\n" + 
				"   ]\n";
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("saludo/{nombre}")
	@Produces({ "text/plain" })
	public String saludoGET(@PathParam("nombre") String nombre) {
		fachadaBean.crearLog();
		return "Hola " + nombre;
	}

	@POST
	@Path("/saludo")
	@Produces({ "text/plain" })
	public String saludoPOST(String nombre) {
		return "Hola " + nombre;
	}
	
    @POST
    @Path("/log")
    @Consumes({ "application/json" })
    @Produces({ "text/plain" })
    public String crearSolicitud(String logreq) {
    	/*
    	 * {
    	 * 	accion:
    	 * modulo:
    	 * fecha:
    	 * }
    	 * */
    	//return "log creado";
    	
    	//fachadaBean.crearLog();
    	
    	LogDTO logdto = new LogDTO();
    	
    	// configure, if necessary:
    	ObjectMapper objectMapper = new ObjectMapper();
    	try {
			logdto = objectMapper.readValue(logreq, LogDTO.class);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//
//    	String carJson =
//    	    "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
//
//    	try {
//    	    Car car = objectMapper.readValue(carJson, Car.class);
//
//    	    System.out.println("car brand = " + car.getBrand());
//    	    System.out.println("car doors = " + car.getDoors());
//    	} catch (IOException e) {
//    	    e.printStackTrace();
//    	}
    	
    	return logdto.getAccion() + "anduvo aparentemente";
    }
    
//    @POST
//    @Path("/RegistrarLog")
//    @Produces(APPLICATION_JSON)
//    @Consumes(APPLICATION_JSON)
//    public LogDTO crearSolicitud(LogDTO log) {
//
//        LogDTO dto = logBean.registrarLog(log);
//        return dto;
//    }

}