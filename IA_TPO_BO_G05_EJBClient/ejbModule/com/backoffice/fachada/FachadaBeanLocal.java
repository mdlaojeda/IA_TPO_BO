package com.backoffice.fachada;

import javax.ejb.Local;

@Local
public interface FachadaBeanLocal {
	public int nuevaSolicitud(int nroUsuario, int nroEstablecimiento, int nroAgencia, int tiposolicitud, int estado);
}
