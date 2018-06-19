package com.backoffice.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backoffice.dto.LogDTO;
import com.backoffice.entidades.LogEntity;

/**
 * Session Bean implementation class LogsBean
 */
@Stateless
@LocalBean
public class LogsBean implements LogsBeanRemote, LogsBeanLocal {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;

    public boolean crearLog(LogDTO logDTO) {
		try {
			LogEntity entity = new LogEntity(logDTO);

			em.persist(entity);
			em.flush();

			//return new LogDTO(entity.getNroLog(), entity.getFecha(), entity.getAccion(), entity.getModulo());
			return true;
		} catch (Exception e) {
			System.out.println("EL ERROR ES: " + e.toString());
		}
		
		return true;
	}

}
