package org.jpa.main._26.pkcomposed;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.OrderComposed;
import org.jpa.entity.OrderPK;

public class OrderCoposedPK {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer = em.find(Customer.class, 1L);
		OrderPK pk = new OrderPK("A",1L);
		OrderComposed order = new OrderComposed();
		order.setId(pk);
		order.setCustomer(customer);
		em.persist(order);
		
		em.getTransaction().commit();
		
		OrderComposed orderComposed = em.find(OrderComposed.class, pk);
		System.out.println(orderComposed.getId().getSerie());

	}

}
