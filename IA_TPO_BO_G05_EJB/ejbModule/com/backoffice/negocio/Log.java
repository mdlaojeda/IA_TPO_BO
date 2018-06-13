package com.backoffice.negocio;

import java.util.Date;

public class Log {
	private int nroLog;
	private Date fecha;
	private int nroModulo;
	private int nroAccion;
	
	public Log() {};
	
	public int getNroLog() {
		return nroLog;
	}
	public void setNroLog(int nroLog) {
		this.nroLog = nroLog;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNroModulo() {
		return nroModulo;
	}
	public void setNroModulo(int nroModulo) {
		this.nroModulo = nroModulo;
	}
	public int getNroAccion() {
		return nroAccion;
	}
	public void setNroAccion(int nroAccion) {
		this.nroAccion = nroAccion;
	}
}
