package org.jpa.main._10.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jpa.entity.Customer;

public class Queries {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select e FROM Customer e");
		List<Customer> list = query.getResultList();
		list.stream().forEach(c -> System.out.println(c));
		
		
		Query query2 = em.createQuery("select e FROM Customer e WHERE e.firstName =:firstName");
		query2.setParameter("firstName", "Odin");
		List<Customer> list2 = query2.getResultList();
		list2.stream().forEach(c -> System.out.println(c));
		
		
		TypedQuery<Customer> query3 = em.createQuery("select e FROM Customer e",Customer.class);
		List<Customer> list3 = query3.getResultList();
		list3.stream().forEach(c -> System.out.println(c));
		

	}

}
