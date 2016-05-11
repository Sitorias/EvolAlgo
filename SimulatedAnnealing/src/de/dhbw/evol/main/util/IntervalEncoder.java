package de.dhbw.evol.main.util;

import java.util.List;
import java.util.Map;

public class IntervalEncoder {	
	private int dimensions = 1;
	private float xMin;
	private float xMax;
	private float epsilon;
	
	IntervalEncoder(float lowerIntervalBorder, float upperIntervalBorder, float epsilon, int dimensions) {
		this.dimensions = dimensions;
		this.xMin = lowerIntervalBorder;
		this.xMax = upperIntervalBorder;
		this.epsilon = epsilon;
		
		createEncodedInterval();
	}
	
	private void createEncodedInterval() {
		double diffInterval = xMax - xMin;
		diffInterval /= epsilon;
		
		double exponent_k = (diffInterval) / (Math.log(2));
				
		exponent_k *= dimensions;
	}
}
