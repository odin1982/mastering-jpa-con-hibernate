package org.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jpa.entity.enums.CustomerStatus;

/**
 * 
 * @author odin @Temporal(TemporalType.DATE) = Solo
 *         fecha @Temporal(TemporalType.TIME) = Solo la
 *         hora @Temporal(TemporalType.TIMESTAMP) = fecha y hora
 *
 *         @Enumerated(EnumType.STRING) = Inserta el nombre del
 *         ENUM @Enumerated(EnumType.ORDINAL) = Inserta la posicion del ENUM
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

	// precision cuantos numeros tendra contando los decimales, 
	// scale= cuentos decimales tendra
	@Column(name = "salario",precision = 4,scale = 2)
	private BigDecimal salario;

	// precision cuantos numeros tendra contando los decimales, scale= cuentos
	// decimales tendra
	@Column(name = "deudas", scale = 4)
	private BigDecimal deudas;

	@Column(name = "birthday", nullable = false)
	private LocalDate birthday;

	@Column(name = "reg_date", nullable = false, updatable = false)
	private LocalDateTime regDate = LocalDateTime.now();

	@Column(name = "localtimes")
	private LocalTime localtime = LocalTime.now();

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_ordinal", nullable = false, length = 8)
	private CustomerStatus status;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_string", nullable = false, length = 8)
	private CustomerStatus status_string;

	@Transient
	private String fullName;

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
		setFullName(firstName + " " + lastName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		setFullName(firstName + " " + lastName);
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

	public CustomerStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerStatus status) {
		this.status = status;
	}

	public CustomerStatus getStatus_string() {
		return status_string;
	}

	public void setStatus_string(CustomerStatus status_string) {
		this.status_string = status_string;
	}

	public String getFullName() {
		return fullName;
	}

	private void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salario=" + salario
				+ ", deudas=" + deudas + ", birthday=" + birthday + ", regDate=" + regDate + ", localtime=" + localtime
				+ ", status=" + status + ", status_string=" + status_string + ", fullName=" + fullName + "]";
	}

}
