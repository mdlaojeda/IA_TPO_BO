package com.backoffice.dao;

import com.backoffice.entidades.ServicioEntity;
import com.backoffice.negocio.Servicio;

public class ServicioDAO {
	
	private static ServicioDAO instancia;
	
	private ServicioDAO(){}
	
	public static ServicioDAO getInstancia() {
		if (instancia == null)
			instancia = new ServicioDAO();
		return instancia;
	}
	
	public void guardar(Servicio recuperado) {
		ServicioEntity servicioAPersistir = this.toEntity(recuperado);
		//TODO: Guardar
	}
	
	public ServicioEntity toEntity(Servicio servicioNegocio) {
		ServicioEntity servicioAPersistir = new ServicioEntity();
		servicioAPersistir.setNroServicio(servicioNegocio.getNroServicio());
		servicioAPersistir.setNroTipoServicio(servicioNegocio.getNroTipoServicio());
		servicioAPersistir.setDescripcion(servicioNegocio.getDescripcion());
		return servicioAPersistir;
	}
	
	public Servicio toNegocio(ServicioEntity servicioRecuperado) {
		Servicio servicioNegocio = new Servicio();
		servicioNegocio.setNroServicio(servicioRecuperado.getNroServicio());
		servicioNegocio.setNroTipoServicio(servicioRecuperado.getNroTipoServicio());
		servicioNegocio.setDescripcion(servicioRecuperado.getDescripcion());
		return servicioNegocio;
	}
	
}
