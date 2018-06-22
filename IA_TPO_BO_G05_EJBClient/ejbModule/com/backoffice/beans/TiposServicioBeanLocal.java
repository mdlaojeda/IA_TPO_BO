package com.backoffice.beans;

import java.util.List;

import javax.ejb.Local;

import com.backoffice.dto.ServicioDTO;
import com.backoffice.dto.TipoServicioDTO;

@Local
public interface TiposServicioBeanLocal {
	public List<TipoServicioDTO> getAll();
	public String crearTipoDeServicio(TipoServicioDTO tsDTO);
	public String editarTipoDeServicio(TipoServicioDTO tsDTO);
	public String borrarTipoDeServicio(Integer nroTipoServicio);
}
