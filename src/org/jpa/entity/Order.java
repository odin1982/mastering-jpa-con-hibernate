package org.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.jpa.entity.enums.Status;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	//LAZY = solo se carga cuando sea requerido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer", nullable = false, updatable = false)
	private Customer customer;

	@Column(name = "reg_date", nullable = false, updatable = false)
	private LocalDateTime regDate = LocalDateTime.now();

	@Column(name = "status", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVO;

	@Column(name = "total", nullable = false)
	private Double total = 0d;

	@OrderBy("ctr desc")
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private List<OrderLine> lines;

	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	private Payment payment;
	
	private void updateTotal() {
		List<OrderLine> lines = getLines();
		double total = 0;
		for (OrderLine line : lines) {
			total += line.getTotal();
		}
		this.total = total;
	}

	public void addLine(OrderLine line) {
		List<OrderLine> lines = getLines();
		line.setOrder(this);
		lines.add(line);
		updateTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<OrderLine> getLines() {
		if (lines == null) {
			lines = new ArrayList<OrderLine>();
		}
		return lines;
	}

	public void setLines(List<OrderLine> lines) {
		this.lines = lines;
		updateTotal();
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		payment.setOrder(this);
		this.payment = payment;
	}

}
