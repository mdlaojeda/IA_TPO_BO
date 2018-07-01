package com.backoffice.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.backoffice.dto.TipoServicioDTO;
import com.backoffice.entidades.TipoServicioEntity;
import com.backoffice.excepciones.TipoServicioException;

/**
 * Session Bean implementation class TiposServicioBean
 */
@Stateless
@LocalBean
public class TiposServicioBean implements TiposServicioBeanRemote {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
    public TiposServicioBean() {}
    
    @SuppressWarnings("unchecked")
	public List<TipoServicioDTO> getAll() throws TipoServicioException {
    	List<TipoServicioDTO> resultado = new ArrayList<>();
        Query query = em.createQuery("SELECT object(s) FROM TipoServicioEntity s ORDER BY s.descripcion ASC");
        try {
	        List<TipoServicioEntity> lista = query.getResultList();
	
	        for (TipoServicioEntity entity : lista){
	            resultado.add(new TipoServicioDTO(entity.getNroTipoServicio(), entity.getDescripcion()));
	        }
        } catch (Exception e) {
			throw new TipoServicioException("Error al traer los tipos de servicio: " + e.getMessage());
		}
        return resultado;
    }
    
	public String crearTipoDeServicio(TipoServicioDTO tsDTO) throws TipoServicioException {
		TipoServicioEntity entity = new TipoServicioEntity(tsDTO);
		try {
			em.persist(entity);
			em.flush();
		} catch (Exception e) {
			throw new TipoServicioException("Error al editar el tipo de servicio: " + e.getMessage());
		}
		return "Tipo de Servicio creado con éxito";
	}
	public String editarTipoDeServicio(TipoServicioDTO tsDTO) throws TipoServicioException {
		TipoServicioEntity entity = new TipoServicioEntity(tsDTO);
		try {
			em.merge(entity);
			em.flush();
		} catch (Exception e) {
			throw new TipoServicioException("Error al editar el tipo de servicio: " + e.getMessage());
		}
		return "Tipo de Servicio editado con éxito";
	}
	
	public String borrarTipoDeServicio(Integer nroTipoServicio) throws TipoServicioException {
		try {
			TipoServicioEntity entity = em.find(TipoServicioEntity.class, nroTipoServicio);
		    em.remove(entity);
		    em.flush();
		} catch (Exception e) {
			throw new TipoServicioException("Error al borrar el tipo de servicio " + String.valueOf(nroTipoServicio) + ": " + e.getMessage());
		}
		return "borrar";
	}

}
