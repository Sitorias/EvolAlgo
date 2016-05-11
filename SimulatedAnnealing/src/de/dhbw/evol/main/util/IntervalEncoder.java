package de.dhbw.evol.main.util;

import java.util.BitSet;
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
		char[] containingArray = new char[countBitsPerNumber];
		
		VectorND resultingVector = new VectorND(dimensions);
		
		for(int i = 0; i < dimensions; i++) {
			for(int j = 0; j < countBitsPerNumber; i++) {
				containingArray[j] = chromosomToConvert.content[i * countBitsPerNumber + j];
			}
			double decodedValue = getFloatFromBinaryCharArray(containingArray);
			
			resultingVector.setElementToValue(i, decodedValue);
		}
		
		return resultingVector;
	}
	
	private double getFloatFromBinaryCharArray(char[] binaryNumber) {
		int decimalNumber = 0;
		
		for(int i = 1; i <= countBitsPerNumber; i++) {
			decimalNumber += binaryNumber[countBitsPerNumber - i] * Math.pow(2, i);
		}
		
		//TODO Hardcoded, has to be replaced!!!
		double resultingValue = (decimalNumber / (Math.pow(2, countBitsPerNumber) - 1)) * 80 - 40;
		
		return resultingValue;
	}
	
	public int getCountBitsPerNumber() {
		return this.countBitsPerNumber;
	}
	
	public int getCountBitsPerVector() {
		return this.countBitsPerVector;
	}
}
