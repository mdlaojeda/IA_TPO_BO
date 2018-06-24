package com.backoffice.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.backoffice.dto.TipoServicioDTO;
import com.backoffice.entidades.ServicioEntity;
import com.backoffice.entidades.TipoServicioEntity;
import com.backoffice.excepciones.TipoServicioException;

/**
 * Session Bean implementation class TiposServicioBean
 */
@Stateless
@LocalBean
public class TiposServicioBean implements TiposServicioBeanRemote, TiposServicioBeanLocal{

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
    public TiposServicioBean() {}
    
    @SuppressWarnings("unchecked")
	public List<TipoServicioDTO> getAll() throws TipoServicioException {
    	List<TipoServicioDTO> resultado = new ArrayList<>();
        Query query = em.createQuery("SELECT object(s) FROM TipoServicioEntity s ORDER BY s.descripcion ASC");
        List<TipoServicioEntity> lista = query.getResultList();

        for (TipoServicioEntity entity : lista){
            resultado.add(new TipoServicioDTO(entity.getNroTipoServicio(), entity.getDescripcion()));
        }

        return resultado;
    }
    
	public String crearTipoDeServicio(TipoServicioDTO tsDTO) throws TipoServicioException {
		TipoServicioEntity entity = new TipoServicioEntity(tsDTO);
		if (entity != null) {
			em.persist(entity);
			em.flush();
			return "Tipo de Servicio creado con éxito";
		} else {
			return "Error al crear el Tipo de Servicio";
		}
	}
	public String editarTipoDeServicio(TipoServicioDTO tsDTO) throws TipoServicioException {
		TipoServicioEntity entity = new TipoServicioEntity(tsDTO);
		if (entity != null) {
			em.merge(entity);
			em.flush();
			return "Tipo de Servicio editado con éxito";
		} else {
			return "Error al editar el Tipo de Servicio";
		}
	}
	
	public String borrarTipoDeServicio(Integer nroTipoServicio) throws TipoServicioException {
		TipoServicioEntity entity = em.find(TipoServicioEntity.class, nroTipoServicio);
	    em.remove(entity);
	    em.flush();
		return "borrar";
	}

}
