package org.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;
import org.jpa.entity.enums.Status;

@Entity
@Table(name = "orders_composed2")
@IdClass(OrderPK.class)
public class OrderComposed2 {

	@Id
	@Column(name="serie")
	private String serie;
	
	@Id
	@Column(name="folio")
	private Long folio;

	//LAZY = solo se carga cuando sea requerido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer", nullable = false, updatable = false)
	private Customer customer;

	@Column(name = "reg_date", nullable = false, updatable = false)
	private LocalDateTime regDate = LocalDateTime.now();

	@Column(name = "status", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVO;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Long getFolio() {
		return folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}

	

}
