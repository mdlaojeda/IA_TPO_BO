package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.ServicioDTO;

@Remote
public interface ServiciosBeanRemote {
	public List<ServicioDTO> getAll();
	public ServicioDTO getById(Integer nroServicio);
}
