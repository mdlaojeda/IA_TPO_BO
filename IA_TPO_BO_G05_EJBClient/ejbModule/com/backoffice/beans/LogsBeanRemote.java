package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.LogDTO;
import com.backoffice.excepciones.LogException;

@Remote
public interface LogsBeanRemote {
	public String crearLog(LogDTO logDTO) throws LogException;
	public List<LogDTO> getAll() throws LogException;
	public String borrar(Integer nroLog) throws LogException;
	public String borrarLogs() throws LogException;
}
