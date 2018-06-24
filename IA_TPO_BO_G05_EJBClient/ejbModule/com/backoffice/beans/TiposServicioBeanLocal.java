package com.backoffice.beans;

import java.util.List;

import javax.ejb.Local;

import com.backoffice.dto.ServicioDTO;
import com.backoffice.dto.TipoServicioDTO;
import com.backoffice.excepciones.TipoServicioException;

@Local
public interface TiposServicioBeanLocal {
	public List<TipoServicioDTO> getAll() throws TipoServicioException;
	public String crearTipoDeServicio(TipoServicioDTO tsDTO) throws TipoServicioException;
	public String editarTipoDeServicio(TipoServicioDTO tsDTO) throws TipoServicioException;
	public String borrarTipoDeServicio(Integer nroTipoServicio) throws TipoServicioException;
}
