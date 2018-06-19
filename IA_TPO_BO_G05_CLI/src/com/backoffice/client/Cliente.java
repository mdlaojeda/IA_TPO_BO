package com.backoffice.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.backoffice.fachada.FachadaBeanRemote;

public class Cliente {

	public static void main(String[] args) throws NamingException {
		
		final Hashtable jndiProperties = new Hashtable();
		  jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		  jndiProperties.put("jboss.naming.client.ejb.context", true);
		  final Context context = new InitialContext(jndiProperties);
		  final String earName = "IA_TPO_BO_G05_EAR"; // Nombre del módulo EAR
		  final String ejbModuleName = "IA_TPO_BO_G05_EJB"; // Nombre del módulo EJB
		  final String distinctName = ""; // Opcional para resolver repeticiones en nombres
		  
		  final String ejbClassName = "FachadaBean"; // Nombre corto del EJB
		  final String fullInterfaceName = FachadaBeanRemote.class.getName();
		  
		  String lookupName = "ejb:" + earName + "/" + ejbModuleName + "/" + 
		      distinctName + "/" + ejbClassName + "!" + fullInterfaceName;
		  System.out.println("Conectando a " + lookupName);
		  FachadaBeanRemote mbr = (FachadaBeanRemote) 
		      context.lookup(lookupName);
		  
		  System.out.println("Respuesta: " + mbr.crearSolicitud(32));
		  //System.out.println("Respuesta: " + mbr.crearLog());

	}

}
