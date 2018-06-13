package com.backoffice.negocio;

import com.backoffice.enums.Estado;
import com.backoffice.enums.TipoSolicitud;

public class Solicitud {
	private int nroSolicitud;
	private int nroUsuario;
	private int nroEstablecimiento;
	private int nroAgencia;
	private TipoSolicitud tipo;
	private Estado estado;
	
	public Solicitud() {}

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
