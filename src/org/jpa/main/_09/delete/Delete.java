package org.jpa.main._09.delete;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.enums.CustomerStatus;

public class Delete {
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

		Customer cust = em.find(Customer.class, 1L);
		System.out.println("Empleado ----> " + cust);

		System.out.println("Se borrara objeto cust ----> " + cust);
		em.remove(cust);
		em.getTransaction().commit();

	}

}
