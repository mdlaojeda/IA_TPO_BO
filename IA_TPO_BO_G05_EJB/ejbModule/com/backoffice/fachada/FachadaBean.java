package com.backoffice.fachada;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.backoffice.beans.*;
import com.backoffice.dto.*;

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
	
	@EJB
	ServiciosBean serviciosBean = new ServiciosBean();
	
	@EJB
	TiposServicioBean tiposServicioBean = new TiposServicioBean();
	
	@EJB
	UtilsBean utilsBean = new UtilsBean();
	
    public FachadaBean() {
        // TODO Auto-generated constructor stub
    }
    
    //-------- Solicitudes --------//
    public String enviarSolicitud(SolicitudDTO sDTO) {
    	return solicitudesBean.crearSolicitud(sDTO).getCodEntidad();
    }
    
	public List<SolicitudDTO> verSolicitudes() {
		return solicitudesBean.getAll();
	}
	    
    //-------- Servicios --------//
    public List<ServicioDTO> obtenerServicios() {
    	return serviciosBean.getAll();
    }
    
    public List<TipoServicioDTO> obtenerTiposServicio() {
    	return tiposServicioBean.getAll();
    }

    //-------- Logs --------//
	public String enviarLog(LogDTO lDTO) {
		return logsBean.crearLog(lDTO);
	}
	
	//-------- Utils --------//
	public String reset() {
		return utilsBean.reset();
	}

}

