package com.backoffice.beans;

import java.util.List;

import javax.ejb.Local;

import com.backoffice.dto.TipoServicioDTO;

@Local
public interface TiposServicioBeanLocal {
	public List<TipoServicioDTO> getAll();
}
