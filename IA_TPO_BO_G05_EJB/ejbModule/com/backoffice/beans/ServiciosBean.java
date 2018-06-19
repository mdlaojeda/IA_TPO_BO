package com.backoffice.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.backoffice.dto.SolicitudDTO;

/**
 * Session Bean implementation class ServiciosBean
 */
@Stateless
@LocalBean
public class ServiciosBean implements ServiciosBeanRemote, ServiciosBeanLocal {

    /**
     * Default constructor. 
     */
    public ServiciosBean() {
        // TODO Auto-generated constructor stub
    }

}
