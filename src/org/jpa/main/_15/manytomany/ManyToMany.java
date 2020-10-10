package org.jpa.main._15.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Clasification;
import org.jpa.entity.Product;

public class ManyToMany {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Clasification c1 = em.find(Clasification.class, 1L);
		Clasification c2 = em.find(Clasification.class, 2L);
		Clasification c3 = em.find(Clasification.class, 3L);
		
		Product p = em.find(Product.class, 1L);
		p.addClasification(c1);
		Product p2 = em.find(Product.class, 2L);
		p2.addClasification(c2);
		p2.addClasification(c3);
		
		em.persist(p);
		em.persist(p2);
		em.getTransaction().commit();
		

		
	}

}
