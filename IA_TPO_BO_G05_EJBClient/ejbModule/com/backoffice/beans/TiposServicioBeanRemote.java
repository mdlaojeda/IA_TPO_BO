package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.TipoServicioDTO;
import com.backoffice.excepciones.TipoServicioException;

@Remote
public interface TiposServicioBeanRemote {
	public List<TipoServicioDTO> getAll() throws TipoServicioException;
	public String crearTipoDeServicio(TipoServicioDTO tsDTO) throws TipoServicioException;
	public String editarTipoDeServicio(TipoServicioDTO tsDTO) throws TipoServicioException;
	public String borrarTipoDeServicio(Integer nroTipoServicio) throws TipoServicioException;
}
