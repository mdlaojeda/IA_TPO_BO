package com.backoffice.fachada;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.LogDTO;
import com.backoffice.dto.ServicioDTO;
import com.backoffice.dto.SolicitudDTO;
import com.backoffice.dto.TipoServicioDTO;
import com.backoffice.excepciones.LogException;
import com.backoffice.excepciones.ServicioException;
import com.backoffice.excepciones.SolicitudException;
import com.backoffice.excepciones.TipoServicioException;

@Remote
public interface FachadaBeanRemote {
	//-------- Solicitudes --------//
	public String enviarSolicitud(SolicitudDTO sDTO) throws SolicitudException;
	
	//-------- Servicios --------//
	public List<ServicioDTO> obtenerServicios() throws ServicioException;
	public List<TipoServicioDTO> obtenerTiposServicio() throws TipoServicioException;
	
	//-------- Logs --------//
	public String enviarLog(LogDTO lDTO) throws LogException;
	
	//-------- Utils --------//
	public String reset();

}
