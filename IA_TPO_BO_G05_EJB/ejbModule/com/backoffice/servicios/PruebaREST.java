package com.backoffice.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Session Bean implementation class PruebaREST
 */
@Stateless
@LocalBean
@Path("/hello")
public class PruebaREST implements PruebaRESTLocal {

	/**
     * Default constructor. 
     */
    public PruebaREST() {
        // TODO Auto-generated constructor stub
    }
 
    @GET
    @Produces("text/plain")
    public String sayHello() {
        return "Hello REST GET"; //TODO: No lo sé hacer andar todavía. Hay que ver como se registra este servicio en la aplicación EAR. (?
    }

}
