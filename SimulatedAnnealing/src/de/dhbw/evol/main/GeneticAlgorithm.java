package de.dhbw.evol.main;

import java.util.Random;

import de.dhbw.evol.main.util.Chromosom;
import de.dhbw.evol.main.util.Evolution;
import de.dhbw.evol.main.util.Fitness;
import de.dhbw.evol.main.util.IntervalEncoder;
import de.dhbw.evol.main.util.Mutator;
import de.dhbw.evol.main.util.Population;
import de.dhbw.evol.main.util.Selector;

import java.util.Random;


public class GeneticAlgorithm {
	private static final double a = 20;
	private static final double b = 0.2;
	private static final double c = 2 * Math.PI;
	private static final int d = 6;
	
	private static final int bitsPerDim = 17;
	private static final int popSize = 10;
	
	
	public GeneticAlgorithm() {
	}

	public static void main(String[] args) {
		Fitness myFitness = new Fitness(a, b, c, d);
		Population myPop = generateStartPopulation();
		
		myPop = Selector.selectFromPopulation(myPop);		
		myPop = Mutator.mutate(myPop, 0.01, bitsPerDim * d);
		
		System.out.println(myPop.population.size());
		String firstString = IntervalEncoder.getInstance().getVectorFromChromosom(myPop.population.get(0)).toString();
		System.out.println(firstString);
	}
	
	private static Population generateStartPopulation(){
		Population myPop = new Population();
		for (int i=0; i < popSize * 7; i++){
			myPop.population.add(generateRandomChromosom());
		}
		return myPop;
	}
	
	private static Chromosom generateRandomChromosom(){
		char[] myArray = new char[d*bitsPerDim];
		Random randomGenerator = new Random();
		randomGenerator.setSeed(System.currentTimeMillis());

		for (int i=0; i>d*bitsPerDim; i++){
			if (randomGenerator.nextBoolean()){
				myArray[i]='1';
			} else {
				myArray[i]='0';
			}
		}
		return new Chromosom(myArray);
		
	}
}
