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
import com.backoffice.entidades.TipoServicioEntity;

/**
 * Session Bean implementation class TiposServicioBean
 */
@Stateless
@LocalBean
public class TiposServicioBean {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
    public TiposServicioBean() {}
    
    @SuppressWarnings("unchecked")
	public List<TipoServicioDTO> getAll() {
    	List<TipoServicioDTO> resultado = new ArrayList<>();
        Query query = em.createQuery("SELECT object(s) FROM TipoServicioEntity s");
        List<TipoServicioEntity> lista = query.getResultList();

        for (TipoServicioEntity entity : lista){
            resultado.add(new TipoServicioDTO(entity.getNroTipoServicio(), entity.getDescripcion()));
        }

        return resultado;
    }

}
