package com.backoffice.fachada;

import javax.ejb.Remote;

import com.backoffice.dto.SolicitudDTO;

@Remote
public interface FachadaBeanRemote {
	
	public SolicitudDTO crearSolicitud(SolicitudDTO sDTO);
	public SolicitudDTO crearSolicitud(int test);
	public boolean crearLog();
	
//	public List<Solicitud> verSolicitudes();
//	public Solicitud verDetalleSolicitud(int solicitudID);
//	public void aprobarSolicitud(int solicitudID);
//	public void desaprobarSolicitud(int solicitudID);
	
	//public void enviarSolicitud(SolicitudDTO sol);
	//public void escribirLog(LogDTO log);
}
