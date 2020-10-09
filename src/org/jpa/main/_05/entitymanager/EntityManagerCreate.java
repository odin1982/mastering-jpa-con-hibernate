package org.jpa.main._05.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreate {
	public static void main(String[] args) {
		//Toma todas las configuraciones del persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
	}

}
