package com.backoffice.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class LogsBean implements LogsBeanRemote, LogsBeanLocal {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
    @SuppressWarnings("unchecked")
	public List<LogDTO> getAll() throws LogException {
    	List<LogDTO> resultado = new ArrayList<>();
        Query query = em.createQuery("SELECT object(l) FROM LogEntity l");
        List<LogEntity> lista = query.getResultList();
        for (LogEntity entity : lista){
            resultado.add(new LogDTO(entity.getNroLog(), entity.getFecha(), entity.getModulo(), entity.getAccion()));
        }
        
        if (resultado.isEmpty()) {
        	throw new LogException("No se encontraron resultados.");
        }
        
        return resultado;
    }

	public String crearLog(LogDTO logDTO) throws LogException {
		String resultado;
		try {
			LogEntity entity = new LogEntity(logDTO);
			em.persist(entity);
			em.flush();
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Log '");
			stringBuilder.append(entity.getNroLog());
			stringBuilder.append("' ingresado a las ");
			stringBuilder.append(new SimpleDateFormat("dd/MM/yyyy, Ka").format(new Date()));
			stringBuilder.append(".");
			resultado = stringBuilder.toString();
		} catch (Exception e) {
			throw new LogException("Error al ingresar el log: " + e.getMessage());
			//resultado = "Error al ingresar el log: " + e.getMessage();
		}
		return resultado;
	}
	
	public String borrar(Integer nroLog) throws LogException {	
		LogEntity entity = em.find(LogEntity.class, nroLog);
		try {
		    em.remove(entity);
		    em.flush();
		} catch (Exception e) {
			throw new LogException("Error al borrar el log: " + e.getMessage());
		}
		return "Log " + entity.getNroLog() + " borrado.";
	}

}