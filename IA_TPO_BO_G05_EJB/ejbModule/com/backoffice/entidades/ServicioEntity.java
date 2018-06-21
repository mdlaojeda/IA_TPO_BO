package com.backoffice.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Servicios")
public class ServicioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroServicio")
	private Integer nroServicio;
	
    @ManyToOne(optional = false)
    @JoinColumn(name = "nroTipoServicio", nullable = false)
	private TipoServicioEntity tipoServicio;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public ServicioEntity() {}

	public Integer getNroServicio() {
		return nroServicio;
	}

	public void setNroServicio(Integer nroServicio) {
		this.nroServicio = nroServicio;
	}
	
    public TipoServicioEntity getTipoServicio() {
        return tipoServicio;
    }
    public void setTipoServicio(TipoServicioEntity tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
