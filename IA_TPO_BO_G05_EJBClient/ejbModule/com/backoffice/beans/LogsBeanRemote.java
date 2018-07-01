package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.LogDTO;
import com.backoffice.excepciones.LogException;

@Remote
public interface LogsBeanRemote {
	public void crearLog(LogDTO logDTO) throws LogException;
	public List<LogDTO> getAll() throws LogException;
	public void borrar(Integer nroLog) throws LogException;
	public void borrarLogs() throws LogException;
}
