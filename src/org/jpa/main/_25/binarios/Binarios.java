package org.jpa.main._25.binarios;

import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Product;

public class Binarios {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try (InputStream stream = Binarios.class.getClassLoader().getResourceAsStream("META-INF/coffee.jpg")) {
			byte[] bytes = new byte[stream.available()];
			System.out.println("bytes ----> " + stream.available());
			stream.read(bytes);

			Product p = new Product();
			p.setImage(bytes);
			p.setName("cafe");
			p.setPrice(100d);

			em.persist(p);

		} catch (Exception e) {
			e.printStackTrace();
		}

		em.getTransaction().commit();
		
		Product productoImagen = em.createNamedQuery("Product.findByName",Product.class)
			.setParameter("name", "cafe")
			.getSingleResult();
		
		System.out.println("id: " + productoImagen.getId() +" ----> "+ productoImagen.getImage().length);

	}

}
