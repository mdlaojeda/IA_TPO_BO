package com.backoffice.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backoffice.dto.SolicitudDTO;
import com.backoffice.entidades.SolicitudEntity;

/**
 * Session Bean implementation class SolicitudesBean
 */
@Stateless
@LocalBean
public class SolicitudesBean implements SolicitudesBeanRemote, SolicitudesBeanLocal {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
	public SolicitudDTO crearSolicitud (SolicitudDTO sDTO) {
		try {
			SolicitudEntity entity = new SolicitudEntity(sDTO);
			em.persist(entity);
			em.flush();
			return new SolicitudDTO(entity.getNroSolicitud(), entity.getDescripcion(), entity.getTipo(), entity.getEstado(), entity.getDireccion());
		} catch (Exception e) {

		}
		return null;
	}
	
	public SolicitudDTO buscarPorNro (int nroSolicitud) { 
		try {
			SolicitudEntity entity = em.find(SolicitudEntity.class, nroSolicitud);
			if (entity != null) {
				return new SolicitudDTO(entity.getNroSolicitud(), entity.getDescripcion(), entity.getTipo(), entity.getEstado(), entity.getDireccion());
			}
			
		} catch (Exception e) {

		}
		return null;
	}
	
}