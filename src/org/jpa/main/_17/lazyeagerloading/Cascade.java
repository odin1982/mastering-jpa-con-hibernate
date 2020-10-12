package org.jpa.main._17.lazyeagerloading;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.Order;
import org.jpa.entity.OrderLine;
import org.jpa.entity.Payment;
import org.jpa.entity.Product;
import org.jpa.entity.enums.PayMethod;

public class Cascade {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		Payment payment = new Payment();
		payment.setAmount(100.23);
		payment.setPayMethod(PayMethod.CASH);
		
		Order o = new Order();
		Customer customer = em.find(Customer.class, 1L);
		o.setPayment(payment);
		o.setCustomer(customer);
		
		Product product = em.find(Product.class, 1L);
		
		for(int i = 1; i<10;i++) {
			OrderLine line = new OrderLine();
			line.setProduct(product);
			line.setQuantity(i*1d);
			line.setUnitPrice(product.getPrice());
			o.addLine(line);
		}
		em.persist(o);
		
		em.getTransaction().commit();
		

		
	}

}
