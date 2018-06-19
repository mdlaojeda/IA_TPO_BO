package com.backoffice.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

import com.backoffice.beans.SolicitudesBean;
import com.backoffice.dto.SolicitudDTO;
import com.backoffice.enums.Estado;

@Stateless
@WebService
@SOAPBinding()
public class SOAP {
    
	@EJB
    private SolicitudesBean solicitudesBean;
    
	@WebMethod
	public String sayHello(String name) {
		return "Hello " + name; 
	}
	
    @WebMethod
    public boolean estaAutorizado(
    	   @WebParam(name="nroSolicitud") 
    	   @XmlElement(required = true) Integer nroSolicitud) {
    	
    	SolicitudDTO dto = null;
    	
    	if (nroSolicitud != null){
    		dto = solicitudesBean.buscarPorNro(nroSolicitud);
    	}
    	
    	if(dto != null && dto.getEstado().equals(Estado.APROBADA)) {
    		return true;
    	} else {
    		return false;
    	}
    }

}