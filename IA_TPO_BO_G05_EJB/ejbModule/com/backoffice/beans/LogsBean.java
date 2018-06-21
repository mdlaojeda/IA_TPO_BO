package com.backoffice.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class LogsBean {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;

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
