package org.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name", length = 30, nullable = false, updatable = false, unique = true)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	// precision cuantos numeros tendra contando los decimales, scale= cuentos
	// decimales tendra
	@Column(name = "salario", precision = 7, scale = 4)
	private BigDecimal salario;

	// precision cuantos numeros tendra contando los decimales, scale= cuentos
	// decimales tendra
	@Column(name = "deudas",scale = 4)
	private BigDecimal deudas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getDeudas() {
		return deudas;
	}

	public void setDeudas(BigDecimal deudas) {
		this.deudas = deudas;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salario=" + salario
				+ "]";
	}
}
