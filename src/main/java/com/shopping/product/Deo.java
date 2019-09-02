package com.shopping.product;

import java.math.BigDecimal;

public class Deo extends Product {

	private BigDecimal volume;

	public Deo(String name, int quantity, BigDecimal unitPrice) {
		super(name, quantity, unitPrice);
	}
	public Deo(String name, int quantity, BigDecimal unitPrice, BigDecimal volume) {
		super(name, quantity, unitPrice);
		this.setVolume(volume);
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

}
