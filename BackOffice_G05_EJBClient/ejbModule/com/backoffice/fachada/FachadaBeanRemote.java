package com.backoffice.fachada;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface FachadaBeanRemote {
	void agregarSolicitud(int solicitudID);
	List<?> getSolicitudes();
	public void agregarServicio();
	public void escribirLog();
}
