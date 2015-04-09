package com.stormy.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		SessionFactory sf = (SessionFactory) sce.getServletContext().getAttribute("SessionFactory");
		sf.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		URL url = HibernateServletContextListener.class.getResource("/hibernate.cfg.xml");
		Configuration cfg = new Configuration();
		cfg.configure(url);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings
				(cfg.getProperties()).build();
		
		SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
        sce.getServletContext().setAttribute("SessionFactory", sf);
		
	}

}
