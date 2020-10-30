package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ordeer")
public class Order {
	@Id
	@Column(name="id")
	private int id;
	public int getId() {
		return id;
	}
	public Order() {
		super();
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Order(int id, int menuid, int quantity, int totalprice) {
		super();
		this.id = id;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	@Column(name="menuid")
	private int menuid;
	@Column(name="quantity")
	private int quantity;
	@Column(name="totalprice")
	private int totalprice;
	
}
