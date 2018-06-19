package com.backoffice.beans;

import javax.ejb.Local;

import com.backoffice.dto.SolicitudDTO;

@Local
public interface SolicitudesBeanLocal {
	public SolicitudDTO crearSolicitud(SolicitudDTO sDTO);
}
