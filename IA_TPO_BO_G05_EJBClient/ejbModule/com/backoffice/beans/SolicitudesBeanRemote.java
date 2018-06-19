package com.backoffice.beans;

import javax.ejb.Remote;

import com.backoffice.dto.SolicitudDTO;

@Remote
public interface SolicitudesBeanRemote {
	public SolicitudDTO crearSolicitud(SolicitudDTO sDTO);
}
