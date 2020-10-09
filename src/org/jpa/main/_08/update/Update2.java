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

public class Update2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		

		em.getTransaction().begin();

		Customer customer = new Customer();
		customer.setId(1L);
		customer.setBirthday(LocalDate.now());
		customer.setDeudas(BigDecimal.TEN);
		customer.setFirstName("Odin");
		customer.setLastName("Araujo Barragan");
		customer.setLocaltime(LocalTime.now());
		customer.setRegDate(LocalDateTime.now());
		customer.setSalario(new BigDecimal(10.23));
		customer.setStatus(CustomerStatus.ACTIVE);
		customer.setStatus_string(CustomerStatus.ACTIVE);
		//se usa cuando ya exiete el objeto en la BD y tu le proporcionas el id
		em.merge(customer);

		em.getTransaction().commit();

		Customer cust = em.find(Customer.class, 1L);
		cust.setFirstName("Ramon");
		cust.setLastName("Lopez Hernandez");
		em.persist(cust);

		System.out.println("Empleado ----> " + cust);
	}

}
