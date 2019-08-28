package com.shopping.product;

import java.math.BigDecimal;

public class Soap extends Product {

	public Soap(BigDecimal unitPrice, int quantity, String productName) {
		super(productName,quantity,unitPrice);
	}

}
