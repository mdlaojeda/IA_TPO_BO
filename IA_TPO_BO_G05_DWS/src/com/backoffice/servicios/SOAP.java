package com.backoffice.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

import com.backoffice.beans.SolicitudesBeanRemote;
import com.backoffice.dto.SolicitudDTO;
import com.backoffice.enums.Estado;
import com.backoffice.excepciones.SolicitudException;

@Stateless
@WebService
@SOAPBinding()
public class SOAP {
    
	@EJB
    private SolicitudesBeanRemote solicitudesBean;
	
    @WebMethod
    public boolean estaAutorizado(
    	   @WebParam(name="codEntidad") 
    	   @XmlElement(required = true) String codEntidad) {
    	
    	SolicitudDTO dto = null;
    	
    	if (codEntidad != null){
    		try {
				dto = solicitudesBean.buscarPorUUID(codEntidad);
			} catch (SolicitudException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(dto != null && dto.getEstado().equals(Estado.APROBADA)) {
    		return true;
    	} else {
    		return false;
    	}
    }
}