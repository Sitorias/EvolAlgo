package de.dhbw.evol.main.util;
import java.util.Random;

/**
 * 
 * @author phillipp
 *	This class will evolve the vectors with random values
 */
public class Evolution {
	private static Evolution instance = new Evolution();
	
	Random randomGenerator;
	
	private Evolution() {
		this.randomGenerator = new Random();
		randomGenerator.setSeed(System.currentTimeMillis());
	}
	
	public static synchronized Evolution getInstance() {		
		return instance;
	}
	
	public VectorND generateRandomVector(int dimension) {
		VectorND vector = new VectorND(dimension);
		
		for(int i = 0; i < vector.getDimension(); i++) {
			double randomValue = randomGenerator.nextDouble();
			
			randomValue = scaleNumberToInterval(randomValue, -40, 40);
			
			vector.setElementToValue(i, randomValue);
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
	
	public VectorND updateNElementsOfVectorWithStep(int n, VectorND vector, double step) {
		if(n > 6) {
			System.out.println("Invalid n");
			return null;
		}
		
		for(int i = 0; i < n; i++) {
			int elementToUpdate = randomGenerator.nextInt(vector.getDimension());
			
			double randomValue = getRandomNumberInInterval(-step, step);
			
			double elementValue = vector.getElement(i);
			
			vector.setElementToValue(elementToUpdate, elementValue + randomValue);
		}
		
		return vector;
	}
	
	public double getRandomNumberInInterval(double lowerBound, double upperBound) {
		double randomNumber = randomGenerator.nextDouble();
		
		randomNumber = scaleNumberToInterval(randomNumber, lowerBound, upperBound);
		
		return randomNumber;
	}
	
	public int getRandomIntInInterval(int bound) {
		return randomGenerator.nextInt(bound);
	}
}
