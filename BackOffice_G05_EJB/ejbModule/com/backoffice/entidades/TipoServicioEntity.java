package com.backoffice.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TiposDeServicio")
public class TipoServicioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroTipoServicio")
	private Integer nroTipoServicio;
	
	@Column(name = "nombre")
	private String nombre;
	
	public TipoServicioEntity() {}

	public int getNroTipoServicio() {
		return nroTipoServicio;
	}

	public void setNroTipoServicio(int nroTipoServicio) {
		this.nroTipoServicio = Integer.valueOf(nroTipoServicio);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
