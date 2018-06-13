package com.backoffice.hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.backoffice.entidades.*;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
	   
    static {
        try {
        	
        	AnnotationConfiguration config = new AnnotationConfiguration();
        	
         	config.addAnnotatedClass(LogEntity.class);
         	config.addAnnotatedClass(ServicioEntity.class);
         	config.addAnnotatedClass(SolicitudEntity.class);
         	config.addAnnotatedClass(TipoServicioEntity.class);
         	
             sessionFactory = config.buildSessionFactory();
             
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
