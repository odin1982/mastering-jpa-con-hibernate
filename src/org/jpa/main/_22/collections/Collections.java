package org.jpa.main._22.collections;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Order;
import org.jpa.entity.Product;

public class Collections {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		
		//QUERY INEFICIENTE
		System.out.println("QUERY INEFICIENTE");
		System.out.println("======================================================================================");
		List<Product> products = new ArrayList<Product>();
		Order order = em.find(Order.class, 1L);
		order.getLines().forEach(o ->{
			products.add(o.getProduct());
		});
		
		products.forEach(x -> System.out.println(x.getName()));
		System.out.println();
		System.out.println();
		
		System.out.println("QUERY EFICIENTE");
		System.out.println("======================================================================================");
		em.createQuery("select p from Order o inner join o.lines l inner join l.product p",Product.class)
			.getResultStream()
			.forEach(x -> System.out.println(x.getName()));
		
		
		em.createQuery("select p from Order o inner join o.lines l inner join l.product p where o.id = :id",Product.class)
		.setParameter("id", 1L)
		.getResultStream()
		.forEach(x -> System.out.println(x.getName()));
		
		
		
		
		
	}
}
