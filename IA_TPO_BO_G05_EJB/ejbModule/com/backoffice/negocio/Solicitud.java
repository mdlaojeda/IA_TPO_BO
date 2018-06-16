package com.backoffice.negocio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.backoffice.enums.Estado;
import com.backoffice.enums.TipoSolicitud;

@Entity
public class Solicitud implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2316484711307088210L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nroSolicitud;
	
	private int nroUsuario;
	private int nroEstablecimiento;
	private int nroAgencia;
	private TipoSolicitud tipo;
	private Estado estado;
	
	public Solicitud() {}
	
	public Solicitud(int nroUsuario, int nroEstablecimiento, int nroAgencia, int tiposolicitud, int estado) {
		this.nroUsuario = nroUsuario;
		this.nroEstablecimiento = nroEstablecimiento;
		this.nroAgencia = nroAgencia;
		this.tipo = TipoSolicitud.AGENCIA;
		this.estado = Estado.PENDIENTE;
	}

	public int getNroSolicitud() {
		return nroSolicitud;
	}

	public void setNroSolicitud(int nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}

	public int getNroUsuario() {
		return nroUsuario;
	}

	public void setNroUsuario(int nroUsuario) {
		this.nroUsuario = nroUsuario;
	}

	public int getNroEstablecimiento() {
		return nroEstablecimiento;
	}

	public void setNroEstablecimiento(int nroEstablecimiento) {
		this.nroEstablecimiento = nroEstablecimiento;
	}

	public int getNroAgencia() {
		return nroAgencia;
	}

	public void setNroAgencia(int nroAgencia) {
		this.nroAgencia = nroAgencia;
	}

	public TipoSolicitud getTipo() {
		return tipo;
	}

	public void setTipo(TipoSolicitud tipo) {
		this.tipo = tipo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
