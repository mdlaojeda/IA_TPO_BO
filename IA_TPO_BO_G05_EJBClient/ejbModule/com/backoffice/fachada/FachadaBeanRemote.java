package com.backoffice.fachada;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FachadaBeanRemote {
	public int nuevaSolicitud(int nroUsuario, int nroEstablecimiento, int nroAgencia, int tiposolicitud, int estado);
	
//	public List<Solicitud> verSolicitudes();
//	public Solicitud verDetalleSolicitud(int solicitudID);
//	public void aprobarSolicitud(int solicitudID);
//	public void desaprobarSolicitud(int solicitudID);
	
	//public void enviarSolicitud(SolicitudDTO sol);
	//public void escribirLog(LogDTO log);
}
