package com.retail.big.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.big.bean.Slabs;
import com.retail.big.service.DiscountCalculator;

@Service
public class DiscountCalculatorImpl implements DiscountCalculator {
	

	private static final String PREMIUM_MEMBERSHIP = "Premium";
	private static final String REGULAR_MEMBERSHIP = "Regular";
	
	
	public double getDiscountValue(String memberShip, Double cartValue) {
		double originalCartValue = cartValue;
		List<Slabs> slabList = getSlabList(memberShip);
		double discountValue = 0;

		for (Slabs slab : slabList) {
			if (cartValue > 0) {
				double slabRange = 0;
				if (slab.getPriceRangeEnd() == 0 || cartValue < slab.getPriceRangeEnd()) {
					slabRange = cartValue;
				} else {
					slabRange = slab.getPriceRangeEnd() - slab.getPriceRangeStart();
				}
				discountValue = (slabRange * slab.getDiscountPercentage()) / 100 + discountValue;
				cartValue = cartValue - slabRange;
			}
		}
		return originalCartValue - discountValue;
	}
	
	private List<Slabs> getSlabList(String memberShip) {
		List<Slabs> slabList = new ArrayList<Slabs>();

		if (REGULAR_MEMBERSHIP.equalsIgnoreCase(memberShip)) {

			Slabs slab1 = new Slabs();
			slab1.setPriceRangeStart(0);
			slab1.setPriceRangeEnd(5000);
			slab1.setDiscountPercentage(0);

			Slabs slab2 = new Slabs();
			slab2.setPriceRangeStart(5000);
			slab2.setPriceRangeEnd(10000);
			slab2.setDiscountPercentage(10);

			Slabs slab3 = new Slabs();
			slab3.setPriceRangeStart(10000);
			slab3.setPriceRangeEnd(0);
			slab3.setDiscountPercentage(20);

			slabList.add(slab1);
			slabList.add(slab2);
			slabList.add(slab3);
		} else if (PREMIUM_MEMBERSHIP.equalsIgnoreCase(memberShip)) {

			Slabs slab1 = new Slabs();
			slab1.setPriceRangeStart(0);
			slab1.setPriceRangeEnd(4000);
			slab1.setDiscountPercentage(10);

			Slabs slab2 = new Slabs();
			slab2.setPriceRangeStart(4000);
			slab2.setPriceRangeEnd(8000);
			slab2.setDiscountPercentage(15);

			Slabs slab3 = new Slabs();
			slab3.setPriceRangeStart(8000);
			slab3.setPriceRangeEnd(12000);
			slab3.setDiscountPercentage(20);

			Slabs slab4 = new Slabs();
			slab4.setPriceRangeStart(12000);
			slab4.setPriceRangeEnd(0);
			slab4.setDiscountPercentage(30);

			slabList.add(slab1);
			slabList.add(slab2);
			slabList.add(slab3);
			slabList.add(slab4);

		}

		return slabList;
	}

}
