package com.backoffice.dao;

import java.util.ArrayList;
import java.util.List;

import com.backoffice.entidades.TipoServicioEntity;
import com.backoffice.negocio.TipoServicio;

public class TipoServicioDAO {
	private static TipoServicioDAO instancia;
	
	private TipoServicioDAO(){}
	
	public static TipoServicioDAO getInstancia() {
		if (instancia == null)
			instancia = new TipoServicioDAO();
		return instancia;
	}
	
	public List<TipoServicio> obtenerTodos() {
		List<TipoServicio> resultado = new ArrayList<TipoServicio>();
		return resultado;
	}
	
	public TipoServicioEntity toEntity(TipoServicio tipoServicioNegocio) {
		TipoServicioEntity tipoServicioAPersistir = new TipoServicioEntity();
		tipoServicioAPersistir.setNroTipoServicio(tipoServicioNegocio.getNroTipoServicio());
		tipoServicioAPersistir.setDescripcion(tipoServicioNegocio.getDescripcion());
		return tipoServicioAPersistir;
	}
	
	public TipoServicio toNegocio(TipoServicioEntity tipoServicioRecuperado) {
		TipoServicio tipoServicioNegocio = new TipoServicio();
		tipoServicioNegocio.setNroTipoServicio(tipoServicioRecuperado.getNroTipoServicio());
		tipoServicioNegocio.setDescripcion(tipoServicioRecuperado.getDescripcion());
		return tipoServicioNegocio;
	}
}
