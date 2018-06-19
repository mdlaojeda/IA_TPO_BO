package com.backoffice.dto;

import com.backoffice.enums.Estado;
import com.backoffice.enums.TipoSolicitud;

public class SolicitudDTO {
	
	private Integer nroSolicitud;
    private String descripcion;
    private TipoSolicitud tipo;
    private Estado estado;
    private String direccion;
    
    public SolicitudDTO() {};
    
    public SolicitudDTO (Integer nroSol, String desc, TipoSolicitud tipoSol, Estado estadoSol, String dir) {
        this.nroSolicitud = nroSol;
        this.descripcion = desc;
        this.tipo = tipoSol;
        this.estado = estadoSol;
        this.direccion = dir;
    }

	public Integer getNroSolicitud() {
		return nroSolicitud;
	}

	public void setNroSolicitud(Integer nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}