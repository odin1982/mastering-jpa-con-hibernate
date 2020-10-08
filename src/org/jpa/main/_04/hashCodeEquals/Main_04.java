package org.jpa.main._04.hashCodeEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.enums.CustomerStatus;

public class Main_04 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Customer customer = new Customer();
		customer.setFirstName("Odin");
		customer.setLastName("Araujo Barragan");
		customer.setSalario(BigDecimal.valueOf(20.5));
		customer.setDeudas(BigDecimal.valueOf(1111111111.881234));
		customer.setBirthday(LocalDate.now());
		customer.setStatus(CustomerStatus.ACTIVE);
		customer.setStatus_string(CustomerStatus.ACTIVE);
		em.persist(customer);

		Customer customer2 = new Customer();
		customer2.setFirstName("Amaya");
		customer2.setLastName("Araujo Hernandez");
		customer2.setSalario(BigDecimal.valueOf(39.5));
		customer2.setBirthday(LocalDate.now());
		customer2.setStatus(CustomerStatus.INACTIVE);
		customer2.setStatus_string(CustomerStatus.INACTIVE);
		em.persist(customer2);

		Customer findObject = em.find(Customer.class, 1L);
		System.out.println("customer ----> " + findObject);

		Customer findObject2 = em.find(Customer.class, 2L);
		System.out.println("customer ----> " + findObject2);
		
		em.getTransaction().commit();
	}
}
