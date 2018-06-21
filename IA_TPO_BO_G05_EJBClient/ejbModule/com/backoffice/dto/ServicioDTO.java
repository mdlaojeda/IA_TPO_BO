package com.backoffice.dto;

import java.io.Serializable;

public class ServicioDTO implements Serializable {

	private static final long serialVersionUID = -6299339535670696561L;
	private Integer nroServicio;
    private String descripcion;
    private TipoServicioDTO tipoServicio;
    
    public ServicioDTO() {}
    
    public ServicioDTO(Integer nroServicio, String descripcion, TipoServicioDTO tipoServicio) {
    	this.nroServicio = nroServicio;
    	this.descripcion = descripcion;
    	this.tipoServicio = tipoServicio;
    }
    
    public Integer getNroServicio() {
    	return nroServicio;
    }
    
    public void setNroServicio(Integer nroServ) {
    	this.nroServicio = nroServ;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

    public TipoServicioDTO getTipoServicio() {
        return tipoServicio;
    }
    public void setTipoServicio(TipoServicioDTO tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
