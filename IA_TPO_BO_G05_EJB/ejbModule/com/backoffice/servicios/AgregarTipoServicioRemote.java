package com.backoffice.servicios;

import javax.ejb.Remote;

@Remote
public interface AgregarTipoServicioRemote {
	public String sayHello(String name);
}
