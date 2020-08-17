package com.messenger.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

    
    public static SessionFactory getSessionFactory()
    {
        Configuration configuration = new Configuration().configure("com/messenger/resources/hibernate.cfg.xml");

        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
        srb.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = srb.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

}
