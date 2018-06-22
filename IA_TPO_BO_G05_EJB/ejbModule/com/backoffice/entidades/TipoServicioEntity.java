package com.backoffice.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.backoffice.dto.TipoServicioDTO;

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

	public TipoServicioEntity(TipoServicioDTO tipoServicio) {
		this.nroTipoServicio = tipoServicio.getNroTipoServicio();
		this.descripcion = tipoServicio.getDescripcion();
	}

	public Integer getNroTipoServicio() {
		return nroTipoServicio;
	}

	public void setNroTipoServicio(Integer nroTipoServicio) {
		this.nroTipoServicio = nroTipoServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
