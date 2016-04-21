package de.dhbw.evol;

import de.dhbw.evol.util.Evolution;
import de.dhbw.evol.util.Fitness;
import de.dhbw.evol.util.Vector6D;

public class SimulatedAnnealing {
	private static final double a = 20;
	private static final double b = 0.2;
	private static final double c = 2;
	private static final double d = 6;
	
	public SimulatedAnnealing() {
	}
	
	public static void main(String[] args){
		Fitness myFitness = new Fitness(a,b,c,d);
		
		Vector6D parameterVector = Evolution.getInstance().generateRandomVector();
		
		double fitnessValue = myFitness.getFitness(parameterVector);
		
		System.out.println(fitnessValue);
	}

}
