package com.retail.big.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.retail.big.service.impl.DiscountCalculatorImpl;

public class DiscountCalculatorImplTest {
	
	private DiscountCalculatorImpl discountCalculator;
	
	@Before
	public void setup() {
		discountCalculator = new DiscountCalculatorImpl();
	}

	@Test
	public void testRegularCustomerDiscount1() {
		double output =discountCalculator.getDiscountValue("Regular", 5000.00);
		assertEquals(5000.00, output, 0.0);
		
	}
	@Test
	public void testRegularCustomerDiscount2() {
		double output = discountCalculator.getDiscountValue("Regular", 10000.00);
		assertEquals(9500.00, output, 0.0);
		
	}
	@Test
	public void testRegularCustomerDiscoun3t() {
		double output = discountCalculator.getDiscountValue("Regular", 15000.00);
		assertEquals(13500.00, output, 0.0);
		
	}
	
	@Test
	public void testPremiumCustomerDiscount1() {
		double output =discountCalculator.getDiscountValue("Premium", 4000.00);
		assertEquals(3600.00, output, 0.0);
		
	}
	@Test
	public void testPremiumCustomerDiscount2() {
		double output = discountCalculator.getDiscountValue("Premium", 8000.00);
		assertEquals(7000.00, output, 0.0);
		
	}
	@Test
	public void testPremiumCustomerDiscoun3t() {
		double output = discountCalculator.getDiscountValue("Premium", 12000.00);
		assertEquals(10200.00, output, 0.0);
		
	}
	@Test
	public void testPremiumCustomerDiscoun4t() {
		double output = discountCalculator.getDiscountValue("Premium", 20000.00);
		assertEquals(15800.00, output, 0.0);
		
	}

}
