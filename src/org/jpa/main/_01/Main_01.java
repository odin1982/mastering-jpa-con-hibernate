package org.jpa.main._01;

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
		em.persist(customer);

		em.getTransaction().commit();

		Customer findObject = em.find(Customer.class, 1L);
		System.out.println("customer ----> " + customer);
	}
}
