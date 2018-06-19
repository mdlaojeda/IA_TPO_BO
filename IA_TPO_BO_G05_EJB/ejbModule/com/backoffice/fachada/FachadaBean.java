package com.backoffice.fachada;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.backoffice.beans.*;
import com.backoffice.dto.LogDTO;
import com.backoffice.dto.SolicitudDTO;
import com.backoffice.enums.Estado;
import com.backoffice.enums.TipoSolicitud;

/**
 * Session Bean implementation class FachadaBean
 */
@Stateless
@LocalBean
public class FachadaBean implements FachadaBeanRemote, FachadaBeanLocal {
	
	@EJB
	SolicitudesBean solicitudesBean = new SolicitudesBean();
	
	@EJB
	LogsBean logsBean = new LogsBean();
	
    public FachadaBean() {
        // TODO Auto-generated constructor stub
    }
    
//    public List<Solicitud> verSolicitudes() {
//    	return solicitudesBean.verSolicitudes();
//    }
//    
//	public Solicitud verDetalleSolicitud(int solicitudID) {
//		return solicitudesBean.verDetalleSolicitud(solicitudID);
//	}
//	
//	public void aprobarSolicitud(int solicitudID) {
//		solicitudesBean.aprobarSolicitud(solicitudID);
//	}
//	
//	public void desaprobarSolicitud(int solicitudID) {
//		solicitudesBean.desaprobarSolicitud(solicitudID);
//	}
    
    public SolicitudDTO crearSolicitud(int test) {
    	SolicitudDTO sdto = new SolicitudDTO();
    	sdto.setDescripcion("sdasa");
    	sdto.setDireccion("sdad");
    	sdto.setEstado(Estado.PENDIENTE);
    	sdto.setTipo(TipoSolicitud.AGENCIA);
		
		return solicitudesBean.crearSolicitud(sdto);
    }
    
    public SolicitudDTO crearSolicitud(SolicitudDTO sDTO) {
		return solicitudesBean.crearSolicitud(sDTO);
    }
    
    public boolean crearLog() {
    	LogDTO test = new LogDTO();
    	test.setAccion("accion");
    	test.setFecha(new Date());
    	test.setModulo("Nombre modulo");
    	
    	return logsBean.crearLog(test);
    }
	
	//public void enviarSolicitud(SolicitudDTO sol) {}
	//public void escribirLog(LogDTO log) {}

}

