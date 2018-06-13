package com.backoffice.fachada;
import java.util.List;
import javax.ejb.Remote;

import com.backoffice.negocio.Solicitud;

@Remote
public interface Fachada {
	
	public List<Solicitud> verSolicitudes();
	public Solicitud verDetalleSolicitud(int solicitudID);
	public void aprobarSolicitud(int solicitudID);
	public void desaprobarSolicitud(int solicitudID);
	
	//public void enviarSolicitud(SolicitudDTO sol);
	//public void escribirLog(LogDTO log);
}
