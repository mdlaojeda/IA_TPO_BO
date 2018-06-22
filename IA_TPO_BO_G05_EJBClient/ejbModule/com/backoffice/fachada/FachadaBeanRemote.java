package com.backoffice.fachada;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.LogDTO;
import com.backoffice.dto.ServicioDTO;
import com.backoffice.dto.SolicitudDTO;
import com.backoffice.dto.TipoServicioDTO;

@Remote
public interface FachadaBeanRemote {
	//-------- Solicitudes --------//
	public String enviarSolicitud(SolicitudDTO sDTO);
	
	//-------- Servicios --------//
	public List<ServicioDTO> obtenerServicios();
	public List<TipoServicioDTO> obtenerTiposServicio();
	
	//-------- Logs --------//
	public String enviarLog(LogDTO lDTO);
	
	//-------- Utils --------//
	public String reset();

}
