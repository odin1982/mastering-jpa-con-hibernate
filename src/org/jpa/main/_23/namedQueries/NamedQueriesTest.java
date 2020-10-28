package org.jpa.main._23.namedQueries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;

import org.jpa.entity.Order;

public class NamedQueriesTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.createNamedQuery("Order.orderByCustomer",Order.class)
			.setParameter("customerID", 1L)
			.getResultStream()
			.forEach(o -> System.out.println(o.getId()));
		
		em.createNamedQuery("Order.orderByCustomerNative",Tuple.class)
		.setParameter("customerID", 1L)
		.getResultStream()
		.forEach(o -> System.out.println(o.get("id")));
		
	}
}
