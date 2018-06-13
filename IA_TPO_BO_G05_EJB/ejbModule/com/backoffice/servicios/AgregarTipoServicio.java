package com.backoffice.servicios;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
/**
 * Session Bean implementation class AgregarTipoServicio
 */
@Stateless
@WebService
public class AgregarTipoServicio implements AgregarTipoServicioRemote, AgregarTipoServicioLocal {

    /**
     * Default constructor. 
     */
    public AgregarTipoServicio() {
        // TODO Auto-generated constructor stub
    }
    
    @WebMethod
    public String sayHello(String name) {
    	return "Hello " + name;
    }
    
    // TODO: Esto anda gracias a este código que sigue. No se si no como registrarlo. Igual esto es SOAP y necesitamos REST.
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/AgregarTipoServicio", new AgregarTipoServicio());
    }

}
