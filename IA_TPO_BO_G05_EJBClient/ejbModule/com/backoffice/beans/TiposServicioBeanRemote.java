package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.TipoServicioDTO;

@Remote
public interface TiposServicioBeanRemote {
	public List<TipoServicioDTO> getAll();
}
