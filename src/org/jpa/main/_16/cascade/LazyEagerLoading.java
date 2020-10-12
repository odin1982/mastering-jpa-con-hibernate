package org.jpa.main._16.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.Order;
import org.jpa.entity.OrderLine;
import org.jpa.entity.Payment;
import org.jpa.entity.Product;
import org.jpa.entity.enums.PayMethod;

public class LazyEagerLoading {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Order order = em.find(Order.class,1L);
		System.out.println(order.getCustomer().getFirstName());
		
		order.getLines().get(0);
	}

}
