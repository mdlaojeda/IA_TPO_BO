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

@Stateless
@LocalBean
public class LogsBean implements LogsBeanRemote, LogsBeanLocal {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;
	
    @SuppressWarnings("unchecked")
	public List<LogDTO> getAll() {
    	List<LogDTO> resultado = new ArrayList<>();
        Query query = em.createQuery("SELECT object(l) FROM LogEntity l");
        List<LogEntity> lista = query.getResultList();
        for (LogEntity entity : lista){
            resultado.add(new LogDTO(entity.getNroLog(), entity.getFecha(), entity.getModulo(), entity.getAccion()));
        }
        return resultado;
    }

	public String crearLog(LogDTO logDTO) {
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
			return stringBuilder.toString();
		} catch (Exception e) {
			return "Error al ingresar el log: " + e.getMessage();
		}
	}

}