package com.backoffice.dto;

import java.io.Serializable;
import java.util.Date;

import com.backoffice.enums.Accion;
import com.backoffice.enums.Modulo;

public class LogDTO implements Serializable {

	private static final long serialVersionUID = 8265711221664960733L;
	
	private Integer nroLog;
	private Date fecha;
	private Modulo modulo;
	private Accion accion;
	
	public LogDTO() {}
	
	public LogDTO(Integer nroLog, Date fecha, Modulo mod, Accion acc) {
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
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public Accion getAccion() {
		return accion;
	}
	public void setAccion(Accion accion) {
		this.accion = accion;
	}
}
