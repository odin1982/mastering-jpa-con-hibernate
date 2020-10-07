package org.jpa.main._01;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;

public class Main_01 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Customer customer = new Customer();
		customer.setFirstName("Odin");
		customer.setLastName("Araujo Barragan");
		customer.setSalario(BigDecimal.valueOf(20.5));
		customer.setDeudas(BigDecimal.valueOf(1111111111.881234));
		em.persist(customer);

		Customer customer2 = new Customer();
		customer2.setFirstName("Amaya");
		customer2.setLastName("Araujo Hernandez");
		customer2.setSalario(BigDecimal.valueOf(39.5));
		em.persist(customer2);

		// prueba de que no permite nombres iguales
		/*
		 * Customer customer3 = new Customer(); customer3.setFirstName("Odin");
		 * customer3.setLastName("Araujo Hernandez"); em.persist(customer3);
		 */

		// prueba de que no permite nombres nullos
//		Customer customer4 = new Customer();
//		customer4.setLastName("Araujo Hernandez");
//		em.persist(customer4);

		em.getTransaction().commit();

		em.getTransaction().begin();
		// prueba de que el nombre no se puede actualizar, no genera exception solo no hace el update
		Customer customer5 = em.find(Customer.class, 1L);
		customer5.setFirstName("Juanito");
		customer5.setLastName("Araujo Hernandez");
		em.persist(customer5);
		em.getTransaction().commit();

		Customer findObject = em.find(Customer.class, 1L);
		System.out.println("customer ----> " + findObject);

		Customer findObject2 = em.find(Customer.class, 2L);
		System.out.println("customer ----> " + findObject2);
	}
}
