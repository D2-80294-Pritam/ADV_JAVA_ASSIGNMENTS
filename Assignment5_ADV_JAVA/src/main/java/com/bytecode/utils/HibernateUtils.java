package com.bytecode.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("In static init block");
		factory = new Configuration() // creates empty config
				.configure()	// reads all props form hib cfg xml
				.buildSessionFactory();	// create singelton Sf from loaded config
				
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
}
