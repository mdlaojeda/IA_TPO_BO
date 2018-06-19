package com.backoffice.fachada;

import javax.ejb.Local;

import com.backoffice.dto.SolicitudDTO;

@Local
public interface FachadaBeanLocal {
	
	public SolicitudDTO crearSolicitud(SolicitudDTO sDTO);
	public SolicitudDTO crearSolicitud(int test);
	public boolean crearLog();
	
//	public List<Solicitud> verSolicitudes();
//	public Solicitud verDetalleSolicitud(int solicitudID);
//	public void aprobarSolicitud(int solicitudID);
//	public void desaprobarSolicitud(int solicitudID);
	
	//public void enviarSolicitud(SolicitudDTO sol);
	//public void escribirLog(LogDTO log);	public int nuevaSolicitud(int nroUsuario, int nroEstablecimiento, int nroAgencia, int tiposolicitud, int estado);
}
