package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.SolicitudDTO;

@Remote
public interface SolicitudesBeanRemote {
	public SolicitudDTO crearSolicitud(SolicitudDTO sDTO);
	public List<SolicitudDTO> getAll();
	public SolicitudDTO buscarPorNro(int idSolicitud);
	public SolicitudDTO buscarPorUUID(String codEntidad);
	public void aprobar(int idSolicitud);
	public void desaprobar(int idSolicitud);
//	public List<Solicitud> verSolicitudes();
//	public Solicitud verDetalleSolicitud(int solicitudID);
//	public void aprobarSolicitud(int solicitudID);
//	public void desaprobarSolicitud(int solicitudID);
}
