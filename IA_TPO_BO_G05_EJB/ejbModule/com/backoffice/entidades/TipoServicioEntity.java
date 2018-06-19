package com.backoffice.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TiposServicio")
public class TipoServicioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroTipoServicio")
	private Integer nroTipoServicio;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public TipoServicioEntity() {}

	public int getNroTipoServicio() {
		return nroTipoServicio;
	}

	public void setNroTipoServicio(int nroTipoServicio) {
		this.nroTipoServicio = Integer.valueOf(nroTipoServicio);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
