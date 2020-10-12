package org.jpa.main._19.typedquery;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.jpa.entity.Order;

public class TypedQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select o from Order o");
		List<Order> orders = query.getResultList();
		orders.stream().forEach(o-> System.out.println(o.getId()));
		
		
		Query q2 = em.createQuery("select o from Order o where o.id = :id");
		q2.setParameter("id", 1L);
		orders = q2.getResultList();
		orders.stream().forEach(o-> System.out.println(o.getId()));
		
		//getSingleResult
		Query q3 = em.createQuery("select o from Order o where o.id = :id");
		q3.setParameter("id", 1L);
		Order order = (Order) q3.getSingleResult();
		System.out.println("order ----> " + order.getId() );
		
		
		//NoResultException = cuando no trae ningun resultado
//		Query q4 = em.createQuery("select o from Order o where o.id = :id");
//		q4.setParameter("id", 100L);
//		order = (Order) q4.getSingleResult();
//		System.out.println("order ----> " + order.getId() );
		
		
		//NonUniqueResultException = cuando no trae un solo resultado
//		Query q5 = em.createQuery("select o from Order o");
//		//q5.setParameter("id", 100L);
//		order = (Order) q5.getSingleResult();
//		System.out.println("order ----> " + order.getId() );
		
		em.createQuery("select o from Order o where o.id = :id and size(o.lines) > :lines",Order.class)
			.setParameter("id",1L)
			.setParameter("lines", 0).getResultList()
			.stream()
			.forEach(x -> System.out.println(x.getId()));
		
		em.createQuery("select o from Order o where size(o.lines) > :lines",Order.class)
		.setParameter("lines", 0).getResultList()
		.stream()
		.forEach(x -> System.out.println(x.getId()));
		
		
		List<Object[]> result = em.createQuery("select o.id,o.total from Order o")
			.getResultList();
		result.stream().forEach(x -> System.out.println(x[0] + " " + x[1]));
		
		// se debe usar con alias sino va  amarcar error por eso se le pone alias
		List<Tuple> results = em.createQuery("select o.id as id,o.total as total from Order o",Tuple.class)
			.getResultList();
		results.stream().forEach(x -> x.get("id"));
		
		
		Object r = em.createNativeQuery("select now()").getSingleResult();
		System.out.println(r);
		
	}

}
