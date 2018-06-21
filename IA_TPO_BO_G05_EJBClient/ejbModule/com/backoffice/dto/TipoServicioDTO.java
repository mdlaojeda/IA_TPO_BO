package com.backoffice.dto;

import java.io.Serializable;
public class TipoServicioDTO implements Serializable {

	private static final long serialVersionUID = 3008011008131773921L;
	private Integer nroTipoServicio;
    private String descripcion;
    
    public TipoServicioDTO() {}
    
    public TipoServicioDTO(Integer nroTipoServicio, String descripcion) {
    	this.nroTipoServicio = nroTipoServicio;
    	this.descripcion = descripcion;
    }
    
    public Integer getNroTipoServicio() {
    	return nroTipoServicio;
    }
    
    public void setNroTipoServicio(Integer nroTipoServ) {
    	this.nroTipoServicio = nroTipoServ;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }
}
