package de.dhbw.evol.main.util;

public class Chromosom {
	public char[] content;
	private double fitness = 10000;
	
	public Chromosom(char[] content){
		this.content = content;
	}
	
	public void calculateFitness(Fitness fitness) {		
		VectorND containingVector = IntervalEncoder.getInstance().getVectorFromChromosom(this);
		
		this.fitness = fitness.getFitness(containingVector);
	}
	
	public double getFitness() {		
		return fitness;
	}
	
}