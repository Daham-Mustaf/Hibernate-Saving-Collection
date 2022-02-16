package main.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	private static final String TAG = new String("HIBERNATE_UTIL: ");

	static {
		if (sessionFactory == null) {
			try {
				// Create StandardServiceRegistry
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				// Create MetadataSources
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				// Create Metadata
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {

				System.out.println(TAG + "Error in creating Session Factory");
				e.printStackTrace();
				if (standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				}
			}
		}
	}

	// Utility method to return SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}