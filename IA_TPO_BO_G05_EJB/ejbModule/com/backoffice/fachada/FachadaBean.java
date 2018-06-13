package com.backoffice.fachada;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.backoffice.controladores.SolicitudesBean;
import com.backoffice.entidades.SolicitudEntity;
import com.backoffice.negocio.Solicitud;

@Stateless
@LocalBean
public class FachadaBean implements Fachada {
	
	private SolicitudesBean solicitudesBean = new SolicitudesBean();
	
    public FachadaBean() {
    	  
    }
    
    public List<Solicitud> verSolicitudes() {
    	return solicitudesBean.verSolicitudes();
    }
    
	public Solicitud verDetalleSolicitud(int solicitudID) {
		return solicitudesBean.verDetalleSolicitud(solicitudID);
	}
	
	public void aprobarSolicitud(int solicitudID) {
		solicitudesBean.aprobarSolicitud(solicitudID);
	}
	
	public void desaprobarSolicitud(int solicitudID) {
		solicitudesBean.desaprobarSolicitud(solicitudID);
	}
	
	//public void enviarSolicitud(SolicitudDTO sol) {}
	//public void escribirLog(LogDTO log) {}

}
