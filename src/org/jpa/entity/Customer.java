package org.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customers")
//@SequenceGenerator(name = "customer_seq",sequenceName ="customer_seq",initialValue = 1,allocationSize = 1 ) //ORACLE DB
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "customer_seq") //ORACLE DB
	@Column(name="id")
	private Long id;
	private String firstName;
	private String lastName;
	
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
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
