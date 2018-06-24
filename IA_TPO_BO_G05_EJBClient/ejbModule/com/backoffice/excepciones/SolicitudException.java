package com.backoffice.excepciones;

public class SolicitudException extends Exception {

	private static final long serialVersionUID = 970694828519846828L;

	public SolicitudException(String mensaje) {
		super(mensaje);
	}
}
