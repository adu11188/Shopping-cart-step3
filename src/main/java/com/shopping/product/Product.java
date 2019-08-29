package com.shopping.product;

import java.math.BigDecimal;
/**
 * Product 
 * 
 * @author adarshsumma
 *
 */
public abstract class Product {

	private String name;
	private int quantity;
	private BigDecimal unitPrice;
	
	public Product(String name, int quantity, BigDecimal unitPrice) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

}
