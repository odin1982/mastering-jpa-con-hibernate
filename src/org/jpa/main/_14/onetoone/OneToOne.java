package org.jpa.main._14.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.Order;
import org.jpa.entity.OrderLine;
import org.jpa.entity.Payment;
import org.jpa.entity.enums.PayMethod;

public class OneToOne {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Customer cust = em.find(Customer.class, 1L);

		Order order = new Order();
		order.setCustomer(cust);

		em.persist(order);

		for (int i = 1; i <= 10; i++) {
			OrderLine line = new OrderLine();
			//line.setProduct("Product" + i);
			line.setQuantity(i * 1d);
			line.setUnitPrice(i * 1000d);
			order.addLine(line);
			em.persist(line);
		}

		Payment payment = new Payment();
		payment.setAmount(order.getTotal());
		payment.setPayMethod(PayMethod.CREDIT);
		order.setPayment(payment);
		em.persist(payment);
		em.persist(order);

		em.getTransaction().commit();

		em.detach(order);
		em.detach(payment);

		Order order2 = em.find(Order.class, 1L);
		System.out.println("paymethod ----> " + order2.getPayment().getPayMethod());

	}

}
