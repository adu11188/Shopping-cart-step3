package com.shopping.test;


import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.shopping.cart.ShoppingCart;
import com.shopping.product.Deo;
import com.shopping.product.Product;
import com.shopping.product.Soap;


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
	
	@Test
	public void testAddingOf5QuantitiesOfProductAndThenincreasedTo8InShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product doveSoaps = new Soap(new BigDecimal("39.99"),5, "DoveSoap"); 
		ShoppingCart cart = shoppingCart.addProductToCart(doveSoaps);
		doveSoaps.setQuantity(8);
		int productQuantityInCart = cart.getTotalQuantitiesOfProductsInCart();
		Assert.assertEquals(8, productQuantityInCart);
	}
	@Test
	public void testTotalPriceInCartAfterAddingOf5QuantitiesOfProductAndThenincreasedTo8InShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product doveSoaps = new Soap(new BigDecimal("39.99"),5, "DoveSoap"); 
		ShoppingCart cart = shoppingCart.addProductToCart(doveSoaps);
		doveSoaps.setQuantity(8);
		BigDecimal totalPrice = cart.getTotalPriceOfProductsInCart();
		BigDecimal result = new BigDecimal("319.92");
		Assert.assertEquals(result, totalPrice);
	}
	@Test
	public void testTotalPriceInCartAfterAddingOf2QuantitiesOfSoapAnd2QuantitiesOfDeo() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product doveSoaps = new Soap(new BigDecimal("39.99"),2, "DoveSoap"); 
		ShoppingCart cart = shoppingCart.addProductToCart(doveSoaps);
		Product Deos = new Deo("AxeDeo",2,new BigDecimal("99.99"));
		shoppingCart.addProductToCart(Deos);
		BigDecimal totalPrice = cart.getTotalPriceOfProductsInCart();
		BigDecimal result = new BigDecimal("279.96");
		Assert.assertEquals(result, totalPrice);
	}
	@Test
	public void testComputeSalesTaxAmount() {
		ShoppingCart shoppingCart = new ShoppingCart();
		BigDecimal salesTaxAmount = shoppingCart.getTotalSalesTaxAmount(12.5f, BigDecimal.valueOf(279.96));
		BigDecimal result = new BigDecimal("34.99500");
		Assert.assertEquals(result, salesTaxAmount);
	}
	@Test
	public void testSalesTaxInCartAfterAddingOf2QuantitiesOfSoapAnd2QuantitiesOfDeo() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Product doveSoaps = new Soap(new BigDecimal("39.99"),2, "DoveSoap"); 
		ShoppingCart cart = shoppingCart.addProductToCart(doveSoaps);
		Product deos = new Deo("AxeDeo",2,new BigDecimal("99.99"));
		shoppingCart.addProductToCart(deos);
		BigDecimal totalPrice = cart.getTotalPriceOfProductsInCart();
		BigDecimal totalPriceWithTax = cart.getTotalPriceOfProductsInCartWithSalesTax(12.5f);
		BigDecimal result = new BigDecimal("35.00");
		BigDecimal salexTax = totalPriceWithTax.subtract(totalPrice);
		Assert.assertEquals(result, salexTax);
	}
}
