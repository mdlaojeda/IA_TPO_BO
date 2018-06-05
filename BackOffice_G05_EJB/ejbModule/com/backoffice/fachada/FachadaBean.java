package com.backoffice.fachada;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.backoffice.entidades.SolicitudEntity;
import com.backoffice.negocio.SolicitudesBean;

@Stateless
@LocalBean
public class FachadaBean implements FachadaBeanRemote, FachadaBeanLocal {
	private SolicitudesBean solicitudesBean = new SolicitudesBean();
	
    public FachadaBean() {
    	  
    }
    
	public void agregarSolicitud(int solicitudID) {
		solicitudesBean.agregarSolicitud(solicitudID);
	}
	   
	public List<SolicitudEntity> getSolicitudes() {
		return solicitudesBean.getSolicitudes();
	}
	
	public void agregarServicio() {
		
	}
	
	public void escribirLog() {
		
	}

}
