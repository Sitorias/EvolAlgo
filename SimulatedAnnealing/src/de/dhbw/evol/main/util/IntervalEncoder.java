package de.dhbw.evol.main.util;

import java.util.List;
import java.util.Map;

public class IntervalEncoder {	
	private int dimensions = 1;
	private float xMin;
	private float xMax;
	private float epsilon;
	private int countBitsPerNumber;
	private int countBitsPerVector;
	
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
				
		countBitsPerNumber = (int) exponent_k;
		countBitsPerNumber++;
		countBitsPerVector = countBitsPerNumber * dimensions;
	}

	public VectorND getVectorFromChromosom(Chromosom chromosomToConvert) {
		
	}
	
	private float getFloatFromBinaryCharArray(char[] binaryNumber) {
		int decimalNumber = 0;
		
		for(int i = 1; i <= countBitsPerNumber; i++) {
			decimalNumber += binaryNumber[countBitsPerNumber - i] * Math.pow(a, b)
		}
	}
	
	public int getCountBitsPerNumber() {
		return this.countBitsPerNumber;
	}
	
	public int getCountBitsPerVector() {
		return this.countBitsPerVector;
	}
}
