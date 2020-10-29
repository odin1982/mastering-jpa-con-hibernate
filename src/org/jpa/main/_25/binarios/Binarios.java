package org.jpa.main._25.binarios;

import java.io.InputStream;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.entity.Customer;
import org.jpa.entity.Image;
import org.jpa.entity.Product;

public class Binarios {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try (InputStream stream = Binarios.class.getClassLoader().getResourceAsStream("META-INF/coffee.jpg")) {
			
			int fileLength = stream.available();
			byte[] bytes = new byte[fileLength];
			System.out.println("bytes ----> " + fileLength);
			stream.read(bytes);
			
			Image image = new Image();
			image.setImage(bytes);
			image.setLength((long)fileLength);
			image.setNameImage("coffee.jpg");
			image.setTypeImage("image/jpeg");
			
			Product p = new Product();
			p.setImage(image);
			p.setName("cafe");
			p.setPrice(100d);

			em.persist(p);
			
			
			Customer customer = new Customer();
			customer.setAvatar(image);
			customer.setFirstName("Manuel");
			customer.setLastName("Lopez");
			customer.setBirthday(LocalDate.now());
			em.persist(customer);

		} catch (Exception e) {
			e.printStackTrace();
		}

		em.getTransaction().commit();
		
		/*Product productoImagen = em.createNamedQuery("Product.findByName",Product.class)
			.setParameter("name", "cafe")
			.getSingleResult();
		
		System.out.println("id: " + productoImagen.getId() +" ----> "+ productoImagen.getImage().length);
		 */
	}

}
