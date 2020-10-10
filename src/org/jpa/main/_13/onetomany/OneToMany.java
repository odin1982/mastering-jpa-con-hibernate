package org.jpa.main._13.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.Order;
import org.jpa.entity.OrderLine;

public class OneToMany {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer cust = em.find(Customer.class, 1L);
		
		Order order = new Order();
		order.setCustomer(cust);
		em.persist(order);
		
		for(int i=1;i<=10;i++) {
			OrderLine line = new OrderLine();
			//line.setProduct("Product"+i);
			line.setQuantity(i*1d);
			line.setUnitPrice(i*1000d);
			order.addLine(line);
			em.persist(line);
		}
		
		em.persist(order);
		em.getTransaction().commit();
		
		em.detach(order);
		
		Order order2 = em.find(Order.class, 1L);
		order2.getLines().stream().forEach(l -> System.out.println("product ----> "+l.getProduct()));

	}

}
