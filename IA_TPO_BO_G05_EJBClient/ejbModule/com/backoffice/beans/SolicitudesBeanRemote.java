package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.SolicitudDTO;
import com.backoffice.excepciones.SolicitudException;

@Remote
public interface SolicitudesBeanRemote {
	public SolicitudDTO crearSolicitud(SolicitudDTO sDTO) throws SolicitudException;
	public List<SolicitudDTO> getAll() throws SolicitudException;
	public SolicitudDTO buscarPorNro(int idSolicitud) throws SolicitudException;
	public SolicitudDTO buscarPorUUID(String codEntidad) throws SolicitudException;
	public void aprobar(int idSolicitud) throws SolicitudException;
	public void desaprobar(int idSolicitud) throws SolicitudException;
}
