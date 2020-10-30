package org.jpa.main._26.pkcomposed;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.OrderComposed;
import org.jpa.entity.OrderComposed2;
import org.jpa.entity.OrderPK;

public class OrderCoposedPK2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer = em.find(Customer.class, 1L);
		OrderComposed2 order = new OrderComposed2();
		order.setSerie("A");
		order.setFolio(1L);
		order.setCustomer(customer);
		em.persist(order);
		
		em.getTransaction().commit();
		
		OrderPK pk = new OrderPK("A",1L);
		OrderComposed2 orderComposed = em.find(OrderComposed2.class, pk);
		System.out.println(orderComposed.getSerie());

	}

}
