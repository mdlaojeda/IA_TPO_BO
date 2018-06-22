package com.backoffice.beans;

import java.util.List;

import javax.ejb.Remote;

import com.backoffice.dto.LogDTO;

@Remote
public interface LogsBeanRemote {
	public String crearLog(LogDTO logDTO);
	public List<LogDTO> getAll();
}
