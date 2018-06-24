package com.backoffice.excepciones;

public class TipoServicioException extends Exception {

	private static final long serialVersionUID = 3314617711494303488L;

	public TipoServicioException(String mensaje) {
		super(mensaje);
	}
}
