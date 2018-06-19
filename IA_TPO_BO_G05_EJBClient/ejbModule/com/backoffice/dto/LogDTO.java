package com.backoffice.dto;

import java.util.Date;

public class LogDTO {
	private Integer nroLog;
	private Date fecha;
	private String modulo;
	private String accion;
	
	public LogDTO() {
		
	}
	
	public LogDTO(Integer nroLog, Date fecha, String mod, String acc) {
		this.nroLog = nroLog;
		this.fecha = fecha;
		this.modulo = mod;
		this.accion = acc;
	}
	
	public Integer getNroLog() {
		return nroLog;
	}
	public void setNroLog(Integer nroLog) {
		this.nroLog = nroLog;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
}
