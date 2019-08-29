package com.shopping.test;


import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.shopping.cart.ShoppingCart;
import com.shopping.product.Soap;
import com.shopping.product.Product;


public class TestShoppingCart {
	
	
	@Test
	public void testNoOfItemsInEmptyCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		int  itemsCount = shoppingCart.getTotalQuantitiesOfProductsInCart();
		Assert.assertEquals(0, itemsCount);
	}

	@Test
	public void testEmptyCartTotalPrice() {
		ShoppingCart shoppingCart = new ShoppingCart();
		BigDecimal  totalPrice = shoppingCart.getTotalPriceOfProductsInCart();
		Assert.assertEquals(0, totalPrice.compareTo(new BigDecimal("0")));
	}
	
	@Test
	public void testAddProductToShoppingCartForQuantity() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product doveSoaps = new Soap(new BigDecimal("39.99"),5, "DoveSoap"); 
		ShoppingCart cart = shoppingCart.addProductToCart(doveSoaps);
		int productQuantityInCart = cart.getTotalQuantitiesOfProductsInCart();
		Assert.assertEquals(5, productQuantityInCart);
	}

	@Test
	public void testAddProductToShoppingCartForCartsTotalPrice() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product doveSoaps = new Soap(new BigDecimal("39.99"),5, "DoveSoap"); 
		ShoppingCart cart = shoppingCart.addProductToCart(doveSoaps);
		BigDecimal totalPrice = cart.getTotalPriceOfProductsInCart();
		BigDecimal result = new BigDecimal("199.95");
		Assert.assertEquals(result, totalPrice);
	}
}
