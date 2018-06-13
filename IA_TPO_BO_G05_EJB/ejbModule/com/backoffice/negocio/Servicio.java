package com.backoffice.negocio;

public class Servicio {
	private int nroServicio;
	private int nroTipoServicio;
	private String descripcion;

	public Servicio() {}

	public int getNroServicio() {
		return nroServicio;
	}

	public void setNroServicio(int nroServicio) {
		this.nroServicio = nroServicio;
	}

	public int getNroTipoServicio() {
		return nroTipoServicio;
	}

	public void setNroTipoServicio(int nroTipoServicio) {
		this.nroTipoServicio = nroTipoServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
