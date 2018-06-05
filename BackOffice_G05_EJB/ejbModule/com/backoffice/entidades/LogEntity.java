package com.backoffice.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Logs")
public class LogEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroLog")
	private Integer nroLog;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "nroModulo")
	private Integer nroModulo;
	
	@Column(name = "nroAccion")
	private Integer nroAccion;
	
	public LogEntity() {}

	public int getNroLog() {
		return nroLog;
	}

	public void setIdLog(int idLog) {
		this.nroLog = Integer.valueOf(idLog);
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
		this.nroModulo = Integer.valueOf(nroModulo);
	}

	public int getNroAccion() {
		return nroAccion;
	}

	public void setNroAccion(int nroAccion) {
		this.nroAccion = Integer.valueOf(nroAccion);
	}
}
