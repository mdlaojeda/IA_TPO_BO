package com.backoffice.beans;

import java.util.List;

import javax.ejb.Local;

import com.backoffice.dto.ServicioDTO;

@Local
public interface ServiciosBeanLocal {
	public List<ServicioDTO> getAll();
	public ServicioDTO getById(Integer nroServicio);
}
