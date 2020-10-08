package org.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author odin
 *	@Temporal(TemporalType.DATE) = Solo fecha
 *	@Temporal(TemporalType.TIME) = Solo la hora
 *	@Temporal(TemporalType.TIMESTAMP) = fecha y hora
 */



@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name", length = 30, nullable = false)
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
	
	@Column(name="birthday",nullable=false)
	private LocalDate birthday;
	
	@Column(name="reg_date",nullable=false,updatable=false)
	private LocalDateTime regDate = LocalDateTime.now();
	
	@Column(name="localtimes")
	private LocalTime localtime = LocalTime.now();

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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalTime getLocaltime() {
		return localtime;
	}

	public void setLocaltime(LocalTime localtime) {
		this.localtime = localtime;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salario=" + salario
				+ ", deudas=" + deudas + ", birthday=" + birthday + ", regDate=" + regDate + ", localtime=" + localtime
				+ "]";
	}

}
