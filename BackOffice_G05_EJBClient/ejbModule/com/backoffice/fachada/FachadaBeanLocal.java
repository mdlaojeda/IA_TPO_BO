package com.backoffice.fachada;

import java.util.List;
import javax.ejb.Local;

@Local
public interface FachadaBeanLocal {
	void agregarSolicitud(int solicitudID);
	List<?> getSolicitudes();
	public void agregarServicio();
	public void escribirLog();
}
