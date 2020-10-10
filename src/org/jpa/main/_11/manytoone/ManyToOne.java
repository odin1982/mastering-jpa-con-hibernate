package org.jpa.main._11.manytoone;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.Order;
import org.jpa.entity.enums.Status;

public class ManyToOne {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

//		em.getTransaction().begin();
//		Customer cust = em.find(Customer.class, 1L);
//		
//		Order order = new Order();
//		order.setCustomer(cust);
//		order.setRegDate(LocalDateTime.now());
//		order.setStatus(Status.ACTIVO);
//		order.setTotal(123.45);
//		
//		em.persist(order);
//		
//		em.getTransaction().commit();

		Order order = em.find(Order.class, 1L);
		System.out.println(order.getTotal());
		System.out.println(order.getCustomer());
	}

}
