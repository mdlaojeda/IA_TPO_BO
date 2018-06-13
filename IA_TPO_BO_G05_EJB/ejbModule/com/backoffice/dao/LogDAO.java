package com.backoffice.dao;

import com.backoffice.entidades.LogEntity;
import com.backoffice.entidades.ServicioEntity;
import com.backoffice.negocio.Log;
import com.backoffice.negocio.Servicio;

public class LogDAO {
	
	private static LogDAO instancia;
	
	private LogDAO(){}
	
	public static LogDAO getInstancia() {
		if (instancia == null)
			instancia = new LogDAO();
		return instancia;
	}
	
	public LogEntity toEntity(Log logNegocio) {
		LogEntity logAPersistir = new LogEntity();
		logAPersistir.setNroLog(logNegocio.getNroLog());
		logAPersistir.setFecha(logNegocio.getFecha());
		logAPersistir.setNroAccion(logNegocio.getNroAccion());
		logAPersistir.setNroModulo(logNegocio.getNroModulo());
		return logAPersistir;
	}
	
	public Log toNegocio(LogEntity logRecuperado) {
		Log logNegocio = new Log();
		logNegocio.setNroLog(logRecuperado.getNroLog());
		logNegocio.setFecha(logRecuperado.getFecha());
		logNegocio.setNroAccion(logRecuperado.getNroAccion());
		logNegocio.setNroModulo(logRecuperado.getNroModulo());
		return logNegocio;
	}
	
}
