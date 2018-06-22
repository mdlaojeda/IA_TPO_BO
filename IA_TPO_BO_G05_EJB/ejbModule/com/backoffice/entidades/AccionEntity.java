package com.backoffice.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.backoffice.dto.AccionDTO;

import javax.persistence.Id;

@Entity
@Table(name="Acciones")
public class AccionEntity implements Serializable {

	private static final long serialVersionUID = -8735791302154759991L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "nroAccion")
	private Integer nroAccion;
	
	@Column (name = "descripcion")
	private String descripcion;
	
	public AccionEntity (String descripcion) {
		this.descripcion = descripcion;
	}
	public AccionEntity (AccionDTO aDTO) {
		this.nroAccion = aDTO.getNroAccion();
		this.descripcion = aDTO.getDescripcion();
	}

	public Integer getNroAccion() {
		return nroAccion;
	}

	public void setNroAccion(Integer nroAccion) {
		this.nroAccion = nroAccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
}
