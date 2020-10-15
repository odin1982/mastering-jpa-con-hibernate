package org.jpa.main._20.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;

import org.jpa.dto.OrderTotalDTO;
import org.jpa.entity.Order;

public class JPQL {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
//		em.createQuery("SELECT SQRT(o.total) FROM Order o ").getResultStream().forEach(System.out::println);
//		em.createQuery("SELECT ABS(o.total) FROM Order o ").getResultStream().forEach(System.out::println);
//		em.createQuery("SELECT o FROM Order o WHERE o.customer.firstName like '%M%'",Order.class)
//			.getResultStream()
//			.forEach(x -> System.out.println(x.getId()));
//		
//		
//		String name ="M";
//		em.createQuery("SELECT o FROM Order o WHERE o.customer.firstName like :name",Order.class)
//		.setParameter("name", "%"+name+"%")
//		.getResultStream()
//		.forEach(x -> System.out.println(x.getId()));
//		
//		
//		
//		em.createQuery("SELECT TRIM(o.customer.firstName) FROM Order o",String.class)
//		.getResultStream()
//		.forEach(System.out::println);
//		
//		em.createQuery("SELECT TRIM(c.firstName) FROM Customer c",String.class)
//		.getResultStream()
//		.forEach(System.out::println);
//		
//		
//		em.createQuery("SELECT o FROM Order o where o.lines IS EMPTY",Order.class)
//			.getResultStream()
//			.forEach(x->System.out.println(x.getId()));
//		
//		em.createQuery("SELECT o.id as id,size(o.lines) as lines FROM Order o where o.lines IS NOT EMPTY",Tuple.class)
//		.getResultStream()
//		.forEach(x->System.out.println(x.get("id")+" "+x.get("lines")));
//		
//		
//		em.createQuery("select e from Order e where e.id = :id or e.total > 100 and UPPER(e.customer.firstName) <> :name",Order.class)
//			.setParameter("id", 1L)
//			.setParameter("name", "rene")
//			.getResultStream()
//			.forEach(x -> System.out.println(x.getCustomer().getFirstName()));
		
		
//		em.createQuery("select e from Order e where e.total between :start and :end",Order.class)
//		.setParameter("start", 1000D)
//		.setParameter("end", 2000D)
//		.getResultStream()
//		.forEach(x -> System.out.println(x.getCustomer().getFirstName()));
		
		
		//DTO unir varios campos de una tabla en un objeto
		List<OrderTotalDTO> resultList = em.createQuery("select new org.jpa.dto.OrderTotalDTO(o.customer.firstName as name,sum(o.total) as total) from Order o group by o.customer.firstName",OrderTotalDTO.class)
		.getResultList();
		
		for(OrderTotalDTO row : resultList) {
			System.out.println(row.getName()+ ", "+row.getTotal());
		}

		
		
	}

}
