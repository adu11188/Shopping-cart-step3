package com.shopping.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.shopping.product.Product;

/**
 * Shopping cart
 * 
 * @author adarshsumma
 *
 */
public class ShoppingCart {

	public ShoppingCart() {
		this.products = new ArrayList<>();
	}

	private List<Product> products;

	/**
	 * Get the total number of products in the shopping cart
	 * 
	 * @return
	 */
	public int getTotalQuantitiesOfProductsInCart() {
		int totalQuantityInCart = 0;
		for (Product product : products) {
			totalQuantityInCart += product.getQuantity();
		}
		return totalQuantityInCart;
	}

	/**
	 * Add a given product to the shopping cart
	 * 
	 * @param product
	 * @return
	 */
	public ShoppingCart addProductToCart(Product product) {
		products.add(product);
		return this;
	}

	/**
	 * Get total price of the all the items in the shopping cart
	 * 
	 * @return
	 */
	public BigDecimal getTotalPriceOfProductsInCart() {
		BigDecimal totalPrice = computeTotalPrice();
		return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private BigDecimal computeTotalPrice() {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (Product product : products) {
			BigDecimal totalProductPrice = product.getUnitPrice().multiply(new BigDecimal(product.getQuantity()));
			totalPrice = totalPrice.add(totalProductPrice);
		}
		return totalPrice;
	}

	public BigDecimal getTotalPriceOfProductsInCartWithSalesTax(float salesTaxRate) {
		BigDecimal totalPrice = computeTotalPrice();
		BigDecimal salexTaxAmount = getTotalSalesTaxAmount(salesTaxRate,totalPrice);
		BigDecimal finalPrice = totalPrice.add(salexTaxAmount);
		return finalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getTotalSalesTaxAmount(float salesTaxRate,BigDecimal totalPrice) {
		float salesTaxFactor = salesTaxRate/100;
		return totalPrice.multiply(BigDecimal.valueOf(salesTaxFactor));
	}
}
