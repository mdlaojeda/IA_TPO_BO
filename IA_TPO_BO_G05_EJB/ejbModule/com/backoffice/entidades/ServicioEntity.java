package com.backoffice.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.backoffice.enums.TipoServicioENUM;

@Entity
@Table(name = "Servicios")
public class ServicioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroServicio")
	private Integer nroServicio;
	
	@Column(name = "nroTipoServicio")
	private Integer nroTipoServicio;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public ServicioEntity() {}

	public int getNroServicio() {
		return nroServicio;
	}

	public void setNroServicio(int nroServicio) {
		this.nroServicio = Integer.valueOf(nroServicio);
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
