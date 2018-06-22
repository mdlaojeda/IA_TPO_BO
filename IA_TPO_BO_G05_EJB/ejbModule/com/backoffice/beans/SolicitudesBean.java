package com.backoffice.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.backoffice.dto.SolicitudDTO;
import com.backoffice.entidades.SolicitudEntity;
import com.backoffice.enums.Estado;

@Stateless
@LocalBean
public class SolicitudesBean implements SolicitudesBeanRemote, SolicitudesBeanLocal {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;

	public SolicitudDTO crearSolicitud(SolicitudDTO sDTO) {
		try {
			SolicitudEntity entity = new SolicitudEntity(sDTO);
			em.persist(entity);
			em.flush();
			return new SolicitudDTO(entity.getIdSolicitud(), entity.getCodEntidad(), entity.getNombre(),
					entity.getDireccion(), entity.getEstado(), entity.getTipo());
		} catch (Exception e) {

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<SolicitudDTO> getAll() {
		List<SolicitudDTO> resultado = new ArrayList<>();
		Query query = em.createQuery("SELECT object(s) FROM SolicitudEntity s");
		List<SolicitudEntity> lista = query.getResultList();

		for (SolicitudEntity entity : lista) {
			resultado.add(new SolicitudDTO(entity.getIdSolicitud(), entity.getCodEntidad(), entity.getNombre(),
					entity.getDireccion(), entity.getEstado(), entity.getTipo()));
		}

		return resultado;
	}

	public SolicitudDTO buscarPorNro(int idSolicitud) {
		try {
			SolicitudEntity entity = em.find(SolicitudEntity.class, idSolicitud);
			if (entity != null) {
				return new SolicitudDTO(entity.getIdSolicitud(), entity.getCodEntidad(), entity.getNombre(),
						entity.getDireccion(), entity.getEstado(), entity.getTipo());
			}

		} catch (Exception e) {

		}
		return null;
	}

	public SolicitudDTO buscarPorUUID(String codEntidad) {
		try {
			
			SolicitudEntity entity = (SolicitudEntity) em.createQuery("FROM SolicitudEntity s WHERE s.codEntidad = :cod")
	                 .setParameter("cod", codEntidad).getSingleResult();
			
			if (entity != null) {
				return new SolicitudDTO(entity.getIdSolicitud(), entity.getCodEntidad(), entity.getNombre(),
						entity.getDireccion(), entity.getEstado(), entity.getTipo());
			}

		} catch (Exception e) {

		}
		return null;
	}
	
	public void aprobar(int idSolicitud) {
		SolicitudEntity entity = em.find(SolicitudEntity.class, idSolicitud);
		if (entity != null) {
			entity.setEstado(Estado.APROBADA);
			em.merge(entity);
			em.flush();	
		}
	}

	public void desaprobar(int idSolicitud) {
		SolicitudEntity entity = em.find(SolicitudEntity.class, idSolicitud);
		if (entity != null) {
			entity.setEstado(Estado.DESAPROBADA);
			em.merge(entity);
			em.flush();	
		}
	}

}
