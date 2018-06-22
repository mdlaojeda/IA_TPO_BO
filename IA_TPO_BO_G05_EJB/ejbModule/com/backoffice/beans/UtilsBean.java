package com.backoffice.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UtilsBean
 */
@Stateless
@LocalBean
public class UtilsBean implements UtilsBeanRemote, UtilsBeanLocal {

	@PersistenceContext(unitName = "TPO_IA")
	private EntityManager em;

    public UtilsBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String reset() {
    	
    	String tiposServicio = "INSERT INTO TiposServicio (nroTipoServicio, descripcion) values \n" + 
    			"(1, 'Comida y Bebida'),\n" + 
    			"(2, 'Entretenimiento'),\n" + 
    			"(3, 'General'),\n" + 
    			"(4, 'Pileta y Bienestar'),\n" + 
    			"(5, 'Servicios de Recepcion'),\n" + 
    			"(6, 'Transporte')";

    	em.createNativeQuery(tiposServicio).executeUpdate();
    	
    	String servicios = "INSERT INTO Servicios (nroTipoServicio, descripcion) values \n" + 
    			"(1,  'Bar'),\n" + 
    			"(1,  'Buffet'),\n" + 
    			"(1,  'Desayuno'),\n" + 
    			"(2,  'Casino'),\n" + 
    			"(2,  'Diarios y revistas'),\n" + 
    			"(2,  'Minicine'),\n" + 
    			"(2,  'Wifi'),\n" + 
    			"(3,  'Aire Acondicionado'),\n" + 
    			"(3,  'Ascensor'),\n" + 
    			"(3,  'Caja Fuerte'),\n" + 
    			"(3,  'Calefaccion'),\n" + 
    			"(4,  'Baño de vapor'),\n" + 
    			"(4,  'Baño Turco'),\n" + 
    			"(4,  'Gimnasio'),\n" + 
    			"(4,  'Lockers'),\n" + 
    			"(5,  'Guardaequipaje'),\n" + 
    			"(5,  'Recepcion 24 horas'),\n" + 
    			"(5,  'Registro de entrada/salida'),\n" + 
    			"(5,  'Servicio de Conserjeria'),\n" + 
    			"(6,  'Alquiler de Autos'),\n" + 
    			"(6,  'Servicio de Traslado')";

    	em.createNativeQuery(servicios).executeUpdate();
    	
		return "ok";
    }

}
