package com.backoffice.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backoffice.negocio.Solicitud;


@Stateless
@LocalBean
public class SolicitudesBean {
	
	@PersistenceContext(unitName="TPO_IA") 
	private EntityManager manager;

    public SolicitudesBean() {}
    
	public int nuevaSolicitud(int nroUsuario, int nroEstablecimiento, int nroAgencia, int tiposolicitud, int estado) {
		Solicitud nueva = new Solicitud (nroUsuario, nroEstablecimiento, nroAgencia, tiposolicitud, estado);
		manager.persist(nueva);
		return nueva.getNroSolicitud();
	}
    
	public List<Solicitud> verSolicitudes() {
		List<Solicitud> respuesta = new ArrayList<Solicitud>();
		respuesta.add(new Solicitud());
		return respuesta;
	}
	
	public Solicitud verDetalleSolicitud(int solicitudID) {
		Solicitud respuesta = new Solicitud();
		return respuesta;
	}
	
	public void aprobarSolicitud(int solicitudID) {
		
	}
	
	public void desaprobarSolicitud(int solicitudID) {
		
	}
	
	//public void enviarSolicitud(SolicitudDTO sol) {}
	//public void escribirLog(LogDTO log) {}

}
