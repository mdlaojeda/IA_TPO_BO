package com.backoffice.beans;

import java.util.List;

import javax.ejb.Local;

import com.backoffice.dto.ServicioDTO;
import com.backoffice.excepciones.ServicioException;

@Local
public interface ServiciosBeanLocal {
	public List<ServicioDTO> getAll() throws ServicioException;
	public ServicioDTO getById(Integer nroServicio) throws ServicioException;
	public String crearServicio(ServicioDTO sDTO) throws ServicioException;
	public String editarServicio(ServicioDTO sDTO) throws ServicioException;
	public String borrarServicio(Integer nroServicio) throws ServicioException;
}
