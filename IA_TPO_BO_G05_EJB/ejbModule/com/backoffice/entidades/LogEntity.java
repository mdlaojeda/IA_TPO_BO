package com.backoffice.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.backoffice.dto.LogDTO;
import com.backoffice.enums.Accion;
import com.backoffice.enums.Modulo;

@Entity
@Table(name = "Logs")
public class LogEntity implements Serializable {
	
	private static final long serialVersionUID = -240934939121263588L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroLog")
	private Integer nroLog;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "modulo", nullable = false)
	private Modulo modulo;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "accion", nullable = false)
	private Accion accion;
	
	public LogEntity() {}
	
	public LogEntity(Date fecha, Modulo mod, Accion acc) {
		this.fecha = fecha;
		this.modulo = mod;
		this.accion = acc;
	}
	
	public LogEntity(LogDTO lDTO) {
		this.fecha = lDTO.getFecha();
		this.modulo = lDTO.getModulo();
		this.accion = lDTO.getAccion();
	}
	public int getNroLog() {
		return nroLog;
	}

	public void setNroLog(int nroLog) {
		this.nroLog = Integer.valueOf(nroLog);
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
