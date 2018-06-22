package com.backoffice.beans;

import java.util.List;

import javax.ejb.Local;

import com.backoffice.dto.LogDTO;

@Local
public interface LogsBeanLocal {
	public String crearLog(LogDTO logDTO);
	public List<LogDTO> getAll();
}
