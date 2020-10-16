package org.jpa.main._21.dates;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Dates {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
//		em.createQuery("select e from Customer e where e.regDate > CURRENT_DATE")
//			.getResultList()
//			.forEach(x ->System.out.println(ReflectionToStringBuilder.toString(x,ToStringStyle.MULTI_LINE_STYLE)));


//		em.createQuery("select YEAR(e.regDate) from Customer e where YEAR(e.regDate) > 2019")
//		.getResultList()
//		.forEach(x ->System.out.println(ReflectionToStringBuilder.toString(x,ToStringStyle.MULTI_LINE_STYLE)));

		//Se recomienda usar LocalDateTime LocalDate o LocalTime de java 8
		//Esto es un enplo de como usar Calendar
		//Calendar como Date siempre te daran la fecha y hora para restringir esto usamos TemporalType
		//TemporaType.DATE = tomara en cuenta solo la fecha
		
		em.createQuery("select YEAR(e.regDate) from Customer e where e.regDate > :regDate")
		.setParameter("regDate",Calendar.getInstance(),TemporalType.DATE)
		.getResultList()
		.forEach(x ->System.out.println(ReflectionToStringBuilder.toString(x,ToStringStyle.MULTI_LINE_STYLE)));
		
		
		em.createQuery("select YEAR(e.regDate) from Customer e where e.regDate > :regDate")
		.setParameter("regDate",new Date(),TemporalType.DATE)
		.getResultList()
		.forEach(x ->System.out.println(ReflectionToStringBuilder.toString(x,ToStringStyle.MULTI_LINE_STYLE)));
		
		

	}

}
