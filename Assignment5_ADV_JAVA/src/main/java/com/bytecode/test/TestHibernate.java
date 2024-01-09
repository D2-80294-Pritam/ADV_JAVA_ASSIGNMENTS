package com.bytecode.test;
import org.hibernate.*;
import static com.bytecode.utils.HibernateUtils.getFactory;

public class TestHibernate {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			System.out.println("Hibernate Up N Running");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
