package com.backoffice.fachada;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.backoffice.negocio.Solicitud;
import com.backoffice.controladores.*;

/**
 * Session Bean implementation class FachadaBean
 */
@Stateless
@LocalBean
public class FachadaBean implements FachadaBeanRemote, FachadaBeanLocal {

    /**
     * Default constructor. 
     */
	SolicitudesBean solicitudesBean = new SolicitudesBean();
	
    public FachadaBean() {
        // TODO Auto-generated constructor stub
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

	public int nuevaSolicitud(int nroUsuario, int nroEstablecimiento, int nroAgencia, int tiposolicitud, int estado) {
    	return solicitudesBean.nuevaSolicitud(nroUsuario, nroEstablecimiento, nroAgencia, tiposolicitud, estado);
    }
	
	//public void enviarSolicitud(SolicitudDTO sol) {}
	//public void escribirLog(LogDTO log) {}

}

