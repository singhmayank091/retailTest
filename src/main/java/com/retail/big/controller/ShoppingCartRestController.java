package com.retail.big.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.retail.big.service.DiscountCalculator;
import com.retail.big.service.impl.DiscountCalculatorImpl;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class ShoppingCartRestController {
	
	@Autowired
	DiscountCalculator discountCalculator;
	

	// DiscountCalculator discountCalculatorService;
	
	@GetMapping("/discountCalculator/{memberShip}/{cartValue}")
	public Double calculateDiscount(@PathVariable String memberShip, @PathVariable double cartValue) {
		System.out.print("calculateDiscount called...." + cartValue + "  "+ memberShip);
		// DiscountCalculator discountCalculatorService = new DiscountCalculatorImpl();
		return discountCalculator.getDiscountValue( memberShip, cartValue);
		
	}


}
