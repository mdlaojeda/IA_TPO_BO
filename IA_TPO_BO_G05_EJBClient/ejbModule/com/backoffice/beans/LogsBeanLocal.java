package com.backoffice.beans;

import java.util.List;

import javax.ejb.Local;

import com.backoffice.dto.LogDTO;
import com.backoffice.excepciones.LogException;

@Local
public interface LogsBeanLocal {
	public String crearLog(LogDTO logDTO) throws LogException;
	public List<LogDTO> getAll() throws LogException;
	public String borrar(Integer nroLog) throws LogException;
}
