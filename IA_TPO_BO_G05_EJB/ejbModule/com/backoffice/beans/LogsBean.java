package com.backoffice.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.backoffice.dto.LogDTO;
import com.backoffice.entidades.LogEntity;
import com.backoffice.excepciones.LogException;

@Stateless
@LocalBean
public class LogsBean implements LogsBeanRemote {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
    @SuppressWarnings("unchecked")
	public List<LogDTO> getAll() throws LogException {
    	List<LogDTO> resultado = new ArrayList<>();
        Query query = em.createQuery("SELECT object(l) FROM LogEntity l");
        try {
	        List<LogEntity> lista = query.getResultList();
	        for (LogEntity entity : lista){
	            resultado.add(new LogDTO(entity.getNroLog(), entity.getFecha(), entity.getModulo(), entity.getAccion()));
	        }
	        
	        if (resultado.isEmpty()) {
	        	// throw new LogException("No se encontraron resultados.");
	        }
        } catch (Exception e) {
        	throw new LogException("Error al traer los logs.");
        }
        
        return resultado;
    }

	public void crearLog(LogDTO logDTO) throws LogException {
		try {
			LogEntity entity = new LogEntity(logDTO);
			em.persist(entity);
			em.flush();
		} catch (Exception e) {
			throw new LogException("Error al ingresar el log: " + e.getMessage());
		}
	}
	
	public void borrar(Integer nroLog) throws LogException {	
		LogEntity entity = em.find(LogEntity.class, nroLog);
		try {
		    em.remove(entity);
		    em.flush();
		} catch (Exception e) {
			throw new LogException("Error al borrar el log: " + e.getMessage());
		}
	}
	
	public void borrarLogs() throws LogException {	
		try {
			em.createQuery("DELETE FROM LogEntity").executeUpdate();
		} catch (Exception e) {
			throw new LogException("Error al borrar los logs: " + e.getMessage());
		}
	}

}