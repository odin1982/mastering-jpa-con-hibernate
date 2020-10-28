package org.jpa.main._23.bulkdeleteupdate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Order;
import org.jpa.entity.enums.Status;

public class BulkDeleteUpdate {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// QUERY INEFICIENTE,trae datos uno por uno, y actualiza uno por uno
		em.createQuery("select o from Order o", Order.class).getResultList().stream().forEach(o -> {
			o.setTotal(1000d);
			em.persist(o);
		});

		System.out.println();
		System.out.println();

		int numUpdates = em.createQuery("update Order set total = 2000 where fk_customer = :idCustomer")
				.setParameter("idCustomer", 1)
				.executeUpdate();
		
		//usar save updates para actulizar montos o cantidades,dinero saldo
		
		int updates = em.createQuery("update Order set total = total + :total,status=:status")
						.setParameter("status", Status.INACTIVO)
						.setParameter("total", 1000d)
						.executeUpdate();
		
		System.out.println("update ---->" + numUpdates);

		
		//En los bulk no aplica la cascada
		
//		int update1 = em.createQuery("delete from OrderLine")
//						.executeUpdate();
//		
//		int update2 = em.createQuery("delete from Order")
//						.executeUpdate();
		
		
		
		
		int numDeletes = em.createQuery("delete from Order where fk_customer = :idCustomer")
				.setParameter("idCustomer", 3).executeUpdate();
		System.out.println("deletes ---->" + numDeletes);

		em.getTransaction().commit();

		// nos quedamos en el minuto 7
	}
}
