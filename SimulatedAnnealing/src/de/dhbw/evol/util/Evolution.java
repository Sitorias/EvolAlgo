package de.dhbw.evol.util;

import java.util.Random;

/**
 * 
 * @author phillipp
 *	This class will evolve the vectors with random values
 */
public class Evolution {
	private static Evolution instance;
	
	Random randomGenerator;
	
	private Evolution() {
		this.randomGenerator = new Random();
	}
	
	public static synchronized Evolution getInstance() {
		return instance;
	}
	
	public Vector6D generateRandomVector() {
		Vector6D vector = new Vector6D();
		
		for(int i = 0; i < vector.getDimension(); i++) {
			double randomValue = randomGenerator.nextDouble();
			
			randomValue = scaleNumberToInterval(randomValue, -100, 100);
		}
		
		return vector;
	}
	
	private double scaleNumberToInterval(double randomNumber, double lowerBound, double upperBound) {
		if(lowerBound > upperBound) {
			return 0;
		}
		
		double scaledNumber = 0;
		
		double intervalLength = upperBound - lowerBound;
		
		scaledNumber = randomNumber * intervalLength;
		scaledNumber += lowerBound;
		
		return scaledNumber;
	}
}
