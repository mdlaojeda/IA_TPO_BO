package com.backoffice.dto;

import java.io.Serializable;

import com.backoffice.enums.Estado;
import com.backoffice.enums.TipoSolicitud;

public class SolicitudDTO implements Serializable {

	private static final long serialVersionUID = -246243060543224762L;

	private Integer idSolicitud;
	private String codEntidad;
	private String nombre;
	private String direccion;
	private Estado estado;
	private TipoSolicitud tipo;

	public SolicitudDTO() {
	};

	public SolicitudDTO(Integer idSol, String codEntidad, String nombre, String dir, Estado estadoSol,
			TipoSolicitud tipoSol) {
		this.idSolicitud = idSol;
		this.codEntidad = codEntidad;
		this.nombre = nombre;
		this.direccion = dir;
		this.tipo = tipoSol;
		this.estado = estadoSol;

	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getCodEntidad() {
		return codEntidad;
	}

	public void setCodEntidad(String codEntidad) {
		this.codEntidad = codEntidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoSolicitud getTipo() {
		return tipo;
	}

	public void setTipo(TipoSolicitud tipo) {
		this.tipo = tipo;
	}

}