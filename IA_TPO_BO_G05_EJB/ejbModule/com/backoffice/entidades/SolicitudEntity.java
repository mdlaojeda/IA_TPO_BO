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
import java.util.UUID;

@Entity
@Table(name = "Solicitudes")
public class SolicitudEntity implements Serializable {

	private static final long serialVersionUID = 4536565580531094021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSolicitud", nullable = false)
	private Integer idSolicitud;

	@Column(name = "codEntidad", nullable = false, unique = true)
	private String codEntidad;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "estado", nullable = false)
	private Estado estado;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo", nullable = false)
	private TipoSolicitud tipo;

	public SolicitudEntity() {};

	public SolicitudEntity(SolicitudDTO sDTO) {
		this.codEntidad = UUID.randomUUID().toString();
		this.nombre = sDTO.getNombre();
		this.direccion = sDTO.getDireccion();
		if (sDTO.getEstado() != null) {
			this.estado = sDTO.getEstado();
		} else {
			this.estado = Estado.PENDIENTE;
		}
		this.tipo = sDTO.getTipo();
	};

	public SolicitudEntity(String nombre, String direccion, Estado estado, TipoSolicitud tipoSolicitud) {
		this.codEntidad = UUID.randomUUID().toString();
		this.nombre = nombre;
		this.direccion = direccion;
		this.estado = estado;
		this.tipo = tipoSolicitud;
	}

	public void Aprobar() {
		this.setEstado(Estado.APROBADA);
	}

	public void Desaprobar() {
		this.setEstado(Estado.DESAPROBADA);
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
