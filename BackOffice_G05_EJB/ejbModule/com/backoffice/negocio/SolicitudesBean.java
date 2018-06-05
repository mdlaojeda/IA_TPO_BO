package com.backoffice.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.backoffice.entidades.SolicitudEntity;


@Stateless
@LocalBean
public class SolicitudesBean {

    public SolicitudesBean() {}
    
	public void agregarSolicitud (int solicitudID) {
		
	}
	   
	public List<SolicitudEntity> getSolicitudes() {
		List<SolicitudEntity> respuesta = new ArrayList<SolicitudEntity>();
		respuesta.add(new SolicitudEntity());
		return respuesta;
	}

}
