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
import com.backoffice.excepciones.SolicitudException;

@Stateless
@LocalBean
public class SolicitudesBean implements SolicitudesBeanRemote {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;

	public SolicitudDTO crearSolicitud(SolicitudDTO sDTO) throws SolicitudException {
		SolicitudEntity entity = new SolicitudEntity(sDTO);
		try {
			em.persist(entity);
			em.flush();
		} catch (Exception e) {
			throw new SolicitudException("Error al crear la solicitud: " + e.getMessage());
		}
		return new SolicitudDTO(entity.getIdSolicitud(), entity.getCodEntidad(), entity.getNombre(),
				entity.getDireccion(), entity.getEstado(), entity.getTipo());
	}

	@SuppressWarnings("unchecked")
	public List<SolicitudDTO> getAll() throws SolicitudException {
		List<SolicitudDTO> resultado = new ArrayList<>();
		Query query = em.createQuery("SELECT object(s) FROM SolicitudEntity s");
		try {
			List<SolicitudEntity> lista = query.getResultList();
	
			for (SolicitudEntity entity : lista) {
				resultado.add(new SolicitudDTO(entity.getIdSolicitud(), entity.getCodEntidad(), entity.getNombre(),
						entity.getDireccion(), entity.getEstado(), entity.getTipo()));
			}
			
		} catch (Exception e) {
			throw new SolicitudException("Error al listar las solicitudes: " + e.getMessage());
		}
		return resultado;
	}

	public SolicitudDTO buscarPorNro(int idSolicitud) throws SolicitudException {
		try {
			SolicitudEntity entity = em.find(SolicitudEntity.class, idSolicitud);
			if (entity != null) {
				return new SolicitudDTO(entity.getIdSolicitud(), entity.getCodEntidad(), entity.getNombre(),
						entity.getDireccion(), entity.getEstado(), entity.getTipo());
			}

		} catch (Exception e) {
			throw new SolicitudException("Error al buscar la solicitud " + String.valueOf(idSolicitud) + ": " + e.getMessage());
		}
		return null;
	}

	public SolicitudDTO buscarPorUUID(String codEntidad) throws SolicitudException {
		try {
			
			SolicitudEntity entity = (SolicitudEntity) em.createQuery("FROM SolicitudEntity s WHERE s.codEntidad = :cod")
	                 .setParameter("cod", codEntidad).getSingleResult();
			
			if (entity != null) {
				return new SolicitudDTO(entity.getIdSolicitud(), entity.getCodEntidad(), entity.getNombre(),
						entity.getDireccion(), entity.getEstado(), entity.getTipo());
			}

		} catch (Exception e) {
			throw new SolicitudException("Error al buscar la solicitud " + codEntidad + ": " + e.getMessage());
		}
		return null;
	}
	
	public void aprobar(int idSolicitud) throws SolicitudException {
		try {
			SolicitudEntity entity = em.find(SolicitudEntity.class, idSolicitud);
			if (entity != null) {
				entity.setEstado(Estado.APROBADA);
				em.merge(entity);
				em.flush();	
			}
		} catch (Exception e) {
			throw new SolicitudException("Error al aprobar la solicitud " + String.valueOf(idSolicitud) + ": " + e.getMessage());
		}
	}

	public void desaprobar(int idSolicitud) throws SolicitudException {
		try {
			SolicitudEntity entity = em.find(SolicitudEntity.class, idSolicitud);
			if (entity != null) {
				entity.setEstado(Estado.DESAPROBADA);
				em.merge(entity);
				em.flush();	
			}
		} catch (Exception e) {
			throw new SolicitudException("Error al desaprobar la solicitud " + String.valueOf(idSolicitud) + ": " + e.getMessage());
		}
	}
	
	public String borrarSolicitudes() throws SolicitudException {	
		try {
			em.createQuery("DELETE FROM SolicitudEntity").executeUpdate();
		} catch (Exception e) {
			throw new SolicitudException("Error al borrar las solicitudes: " + e.getMessage());
		}
		return "Solicitudes borradas";
	}

}
