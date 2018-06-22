package com.backoffice.beans;

import java.util.List;

import javax.ejb.Local;

import com.backoffice.dto.ServicioDTO;

@Local
public interface ServiciosBeanLocal {
	public List<ServicioDTO> getAll();
	public ServicioDTO getById(Integer nroServicio);
	public String crearServicio(ServicioDTO sDTO);
	public String editarServicio(ServicioDTO sDTO);
	public String borrarServicio(Integer nroServicio);
}
