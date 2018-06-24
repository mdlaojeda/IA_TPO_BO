package com.backoffice.excepciones;

public class ServicioException extends Exception {
	
	private static final long serialVersionUID = 5334101210647687620L;

	public ServicioException(String mensaje) {
		super(mensaje);
	}
}
