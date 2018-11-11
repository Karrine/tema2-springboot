package com.unitbv.labs.tema2springboot.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public class ConnectionManager {
	EntityManagerFactory emf = null;
	private String persistenceUnitName;

	public ConnectionManager(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
	}

	public EntityManagerFactory getEMFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		}
		return emf;
	}

	public void close() {
		if (emf != null && !emf.isOpen()) {
			emf.close();
		}
	}
}

