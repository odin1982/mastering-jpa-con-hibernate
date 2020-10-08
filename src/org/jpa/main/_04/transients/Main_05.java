package org.jpa.main._04.transients;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.enums.CustomerStatus;

public class Main_05 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

//		Customer customer1 = em.find(Customer.class, 1L);
//		Customer customer2 = em.find(Customer.class, 1L);
//		System.out.println("Are equals? " + customer1.equals(customer2));
		
		// Si ejecutamos esto sin sobreescribir los metodos HashCode e Equals te dara un false
		// si los sobreescribes te dara true
		Customer c1 = em.find(Customer.class, 1L);
		em.detach(c1);
		Customer c2 = em.find(Customer.class, 1L);
		System.out.println("Are equals? " + c1.equals(c2));
	}
}
