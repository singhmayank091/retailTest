package com.retail.big.service;

public interface DiscountCalculator {
	public double getDiscountValue(String membership, Double cartValue);
}
