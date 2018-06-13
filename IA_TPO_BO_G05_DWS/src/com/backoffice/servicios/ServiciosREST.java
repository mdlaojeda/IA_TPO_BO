package com.backoffice.servicios;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
public class ServiciosREST {

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
		String json = "{ \"servicios\": [{ \"id\": 1, \"descripcion\": \"test 1\" }, { \"id\": 2, \"descripcion\": \"test 1\" } ]}";	
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("saludo/{nombre}")
	@Produces({ "text/plain" })
	public String saludoGET(@PathParam("nombre") String nombre) {
		return "Hola " + nombre;
	}

	@POST
	@Path("/saludo")
	@Produces({ "text/plain" })
	public String saludoPOST(String nombre) {
		return "Hola " + nombre;
	}

}