package org.jpa.main._08.update;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.enums.CustomerStatus;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		

		em.getTransaction().begin();

		Customer customer = new Customer();
		customer.setBirthday(LocalDate.now());
		customer.setDeudas(BigDecimal.TEN);
		customer.setFirstName("Odin");
		customer.setLastName("Araujo Barragan");
		customer.setLocaltime(LocalTime.now());
		customer.setRegDate(LocalDateTime.now());
		customer.setSalario(new BigDecimal(10.23));
		customer.setStatus(CustomerStatus.ACTIVE);
		customer.setStatus_string(CustomerStatus.ACTIVE);
		em.persist(customer);
		
		Customer customer2 = new Customer();
		customer2.setBirthday(LocalDate.now());
		customer2.setDeudas(BigDecimal.TEN);
		customer2.setFirstName("Amaya");
		customer2.setLastName("Araujo Hernandez");
		customer2.setLocaltime(LocalTime.now());
		customer2.setRegDate(LocalDateTime.now());
		customer2.setSalario(new BigDecimal(10.23));
		customer2.setStatus(CustomerStatus.ACTIVE);
		customer2.setStatus_string(CustomerStatus.ACTIVE);
		em.persist(customer2);

		em.getTransaction().commit();

		Customer cust = em.find(Customer.class, 1L);
		cust.setFirstName("Ramon");
		cust.setLastName("Lopez Hernandez");
		em.persist(cust);

		System.out.println("Empleado ----> " + cust);
	}

}
