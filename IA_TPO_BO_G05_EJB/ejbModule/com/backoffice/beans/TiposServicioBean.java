package com.backoffice.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TiposServicioBean
 */
@Stateless
@LocalBean
public class TiposServicioBean implements TiposServicioBeanRemote, TiposServicioBeanLocal {

    /**
     * Default constructor. 
     */
    public TiposServicioBean() {
        // TODO Auto-generated constructor stub
    }

}
