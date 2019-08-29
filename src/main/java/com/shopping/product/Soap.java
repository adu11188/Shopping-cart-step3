package com.shopping.product;

import java.math.BigDecimal;
/**
 * A Soap product
 * 
 * @author adarshsumma
 *
 */
public class Soap extends Product {

	private BigDecimal weight;
	
	public Soap(BigDecimal unitPrice, int quantity, String productName) {
		super(productName,quantity,unitPrice);
	}

	public Soap(BigDecimal unitPrice, int quantity, String productName,BigDecimal weight) {
		super(productName,quantity,unitPrice);
		this.weight=weight;
	}
	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

}
