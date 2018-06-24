package com.backoffice.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.backoffice.dto.ServicioDTO;
import com.backoffice.dto.TipoServicioDTO;

import com.backoffice.entidades.ServicioEntity;
import com.backoffice.excepciones.LogException;
import com.backoffice.excepciones.ServicioException;

@Stateless
@LocalBean
public class ServiciosBean implements ServiciosBeanRemote, ServiciosBeanLocal {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
    public ServiciosBean() {}
    
    @SuppressWarnings("unchecked")
	public List<ServicioDTO> getAll() throws ServicioException {
    	List<ServicioDTO> resultado = new ArrayList<>();
        Query query = em.createQuery("SELECT object(s) FROM ServicioEntity s ORDER BY s.tipoServicio.descripcion ASC, s.descripcion ASC");
        List<ServicioEntity> lista = query.getResultList();

        for (ServicioEntity entity : lista) {
        	TipoServicioDTO tipoServDTO = new TipoServicioDTO(entity.getTipoServicio().getNroTipoServicio(), entity.getTipoServicio().getDescripcion());
            resultado.add(new ServicioDTO(entity.getNroServicio(), entity.getDescripcion(), tipoServDTO));
        }
        if (resultado.isEmpty()) {
        	throw new ServicioException("No se encontraron Servicios.");
        }
        return resultado;
    }
    
	public ServicioDTO getById(Integer nroServicio) throws ServicioException {
		ServicioEntity entity = new ServicioEntity();
		TipoServicioDTO tipoServDTO = new TipoServicioDTO();
		try {
			entity = (ServicioEntity) em.createQuery("SELECT object(s) FROM ServicioEntity s WHERE s.nroServicio = :nroServicio").setParameter("nroServicio", nroServicio).getSingleResult();
			tipoServDTO = new TipoServicioDTO(entity.getTipoServicio().getNroTipoServicio(), entity.getTipoServicio().getDescripcion());
		} catch (Exception e) {
			throw new ServicioException("No se encontraron Servicios.");
		}
        
        return new ServicioDTO(entity.getNroServicio(), entity.getDescripcion(), tipoServDTO);
    }
	
	public String crearServicio(ServicioDTO sDTO) throws ServicioException {
		ServicioEntity entity = new ServicioEntity(sDTO);
		if (entity != null) {
			em.persist(entity);
			em.flush();
			return "Servicio creado con éxito";
		} else {
			return "Error al crear el Servicio";
		}
	}
	public String editarServicio(ServicioDTO sDTO) throws ServicioException {
		ServicioEntity entity = new ServicioEntity(sDTO);
		if (entity != null) {
			em.merge(entity);
			em.flush();
			return "Servicio editado con éxito";
		} else {
			return "Error al editar el Servicio";
		}
	}
	public String borrarServicio(Integer nroServicio) throws ServicioException {	
		ServicioEntity entity = em.find(ServicioEntity.class, nroServicio);
	    em.remove(entity);
	    em.flush();
		return "borrar";
	}
}
