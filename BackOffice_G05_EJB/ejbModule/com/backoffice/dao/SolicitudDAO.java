package com.backoffice.dao;

import com.backoffice.entidades.SolicitudEntity;
import com.backoffice.negocio.Solicitud;

import java.util.ArrayList;
import java.util.List;

public class SolicitudDAO {
	
	private static SolicitudDAO instancia;
	
	private SolicitudDAO(){}
	
	public static SolicitudDAO getInstancia() {
		if (instancia == null)
			instancia = new SolicitudDAO();
		return instancia;
	}
	
	public List<Solicitud> obtenerTodas() {
		List<Solicitud> resultado = new ArrayList<Solicitud>();
		return resultado;
	}
	
	public void guardar(Solicitud recuperado) {
		SolicitudEntity solicitudAPersistir = this.toEntity(recuperado);
		//TODO: Guardar
	}
	
	public SolicitudEntity toEntity(Solicitud solicitudNegocio) {
		SolicitudEntity solicitudAPersistir = new SolicitudEntity();
		solicitudAPersistir.setNroSolicitud(solicitudNegocio.getNroSolicitud());
		solicitudAPersistir.setNroUsuario(solicitudNegocio.getNroUsuario());
		solicitudAPersistir.setNroEstablecimiento(solicitudNegocio.getNroEstablecimiento());
		solicitudAPersistir.setNroAgencia(solicitudNegocio.getNroAgencia());
		solicitudAPersistir.setTipo(solicitudNegocio.getTipo());
		solicitudAPersistir.setEstado(solicitudNegocio.getEstado());
		return solicitudAPersistir;
	}
	
	public Solicitud toNegocio(SolicitudEntity solicitudRecuperada) {
		Solicitud solicitudNegocio = new Solicitud();
		solicitudNegocio.setNroSolicitud(solicitudRecuperada.getNroSolicitud());
		solicitudNegocio.setNroUsuario(solicitudRecuperada.getNroUsuario());
		solicitudNegocio.setNroEstablecimiento(solicitudRecuperada.getNroEstablecimiento());
		solicitudNegocio.setNroAgencia(solicitudRecuperada.getNroAgencia());
		solicitudNegocio.setTipo(solicitudRecuperada.getTipo());
		solicitudNegocio.setEstado(solicitudRecuperada.getEstado());
		return solicitudNegocio;
	}

}
