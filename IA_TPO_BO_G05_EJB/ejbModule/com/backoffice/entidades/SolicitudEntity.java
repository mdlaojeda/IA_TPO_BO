package com.backoffice.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.backoffice.dto.SolicitudDTO;
import com.backoffice.enums.Estado;
import com.backoffice.enums.TipoSolicitud;

@Entity
@Table(name = "Solicitudes")
public class SolicitudEntity implements Serializable {

	private static final long serialVersionUID = 4536565580531094021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroSolicitud", nullable = false)
	private Integer nroSolicitud;
	
	@Column(name = "descripcion")
	private String descripcion;

    @Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo", nullable = false)
	private TipoSolicitud tipo;

    @Enumerated(EnumType.ORDINAL)
	@Column(name = "estado", nullable = false)
	private Estado estado;
	
	@Column(name = "direccion")
	private String direccion;
	
	public SolicitudEntity() {};
	
	public SolicitudEntity(SolicitudDTO sDTO) {
		this.descripcion = sDTO.getDescripcion();
		this.tipo = sDTO.getTipo();
		if(sDTO.getEstado() != null) {
			this.estado = sDTO.getEstado();
		} else {
			this.estado = Estado.PENDIENTE;
		} 
		this.direccion = sDTO.getDireccion();
	};
	
	public SolicitudEntity(String descripcion, TipoSolicitud tipo, Estado estado, String direccion) {		
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.estado = estado;
		this.direccion = direccion;
	};

	public int getNroSolicitud() {
		return nroSolicitud;
	}

	public void setNroSolicitud(int nroSolicitud) {
		this.nroSolicitud = Integer.valueOf(nroSolicitud);
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

	public void setDireccion(String dir) {
		this.direccion = dir;
	}

	public void Aprobar() {
		this.setEstado(Estado.APROBADA);
	}

	public void Desaprobar() {
		this.setEstado(Estado.DESAPROBADA);
	}

}
