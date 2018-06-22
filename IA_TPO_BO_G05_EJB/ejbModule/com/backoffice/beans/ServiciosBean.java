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

@Stateless
@LocalBean
public class ServiciosBean implements ServiciosBeanRemote, ServiciosBeanLocal {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
    public ServiciosBean() {}
    
    @SuppressWarnings("unchecked")
	public List<ServicioDTO> getAll() {
    	List<ServicioDTO> resultado = new ArrayList<>();
        Query query = em.createQuery("SELECT object(s) FROM ServicioEntity s ORDER BY s.tipoServicio.descripcion ASC, s.descripcion ASC");
        List<ServicioEntity> lista = query.getResultList();

        for (ServicioEntity entity : lista) {
        	TipoServicioDTO tipoServDTO = new TipoServicioDTO(entity.getTipoServicio().getNroTipoServicio(), entity.getTipoServicio().getDescripcion());
            resultado.add(new ServicioDTO(entity.getNroServicio(), entity.getDescripcion(), tipoServDTO));
        }

        return resultado;
    }
    
	public ServicioDTO getById(Integer nroServicio) {
        Query query = em.createQuery("SELECT object(s) FROM ServicioEntity s WHERE s.nroServicio = :nroServicio");
        query.setParameter("nroServicio", nroServicio);
        ServicioEntity entity = (ServicioEntity) query.getSingleResult();
        
        TipoServicioDTO tipoServDTO = new TipoServicioDTO(entity.getTipoServicio().getNroTipoServicio(), entity.getTipoServicio().getDescripcion());

        return new ServicioDTO(entity.getNroServicio(), entity.getDescripcion(), tipoServDTO);
    }
	
	public String crearServicio(ServicioDTO sDTO) {
		ServicioEntity entity = new ServicioEntity(sDTO);
		if (entity != null) {
			em.persist(entity);
			em.flush();
			return "Servicio creado con éxito";
		} else {
			return "Error al crear el Servicio";
		}
	}
	public String editarServicio(ServicioDTO sDTO) {
		ServicioEntity entity = new ServicioEntity(sDTO);
		if (entity != null) {
			em.merge(entity);
			em.flush();
			return "Servicio editado con éxito";
		} else {
			return "Error al editar el Servicio";
		}
	}
	public String borrarServicio(Integer nroServicio) {
		return "borrar";
	}
}
