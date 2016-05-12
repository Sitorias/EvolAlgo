package de.dhbw.evol.main;

import java.util.Random;

import de.dhbw.evol.main.util.Chromosom;
import de.dhbw.evol.main.util.Evolution;
import de.dhbw.evol.main.util.Fitness;
import de.dhbw.evol.main.util.IntervalEncoder;
import de.dhbw.evol.main.util.Mutator;
import de.dhbw.evol.main.util.Population;
import de.dhbw.evol.main.util.Recombinator;
import de.dhbw.evol.main.util.Selector;
import de.dhbw.evol.main.util.VectorND;

import java.util.Random;


public class GeneticAlgorithm {
	private static final double a = 20;
	private static final double b = 0.2;
	private static final double c = 2 * Math.PI;
	private static final int d = 6;
	
	private static final int bitsPerDim = 17;
	private static final int popSize = 10;
	
	private static Fitness fitness;
	
	public GeneticAlgorithm() {
	}

	public static void main(String[] args) {
		fitness = new Fitness(a, b, c, d);
		Population myPop = generateStartPopulation();
		
		for(int i = 0; i < 10000; i++) {
			myPop = Selector.selectFromPopulation(myPop);		
			myPop = Recombinator.recombinate(myPop, bitsPerDim * d);
			myPop = Mutator.mutate(myPop, 0.01, bitsPerDim * d);
		}
		
		System.out.println(myPop.population.size());
		
		String firstString = IntervalEncoder.getInstance().getVectorFromChromosom(myPop.population.get(0)).toString();
		System.out.println(firstString);
		
		System.out.println(getBestIndividual(myPop).toString());
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

		for (int i=0; i<d*bitsPerDim; i++){
			if (randomGenerator.nextBoolean()){
				myArray[i]=1;
			} else {
				myArray[i]=0;
			}
		}
		Chromosom resultingChromosom = new Chromosom(myArray);
		resultingChromosom.calculateFitness(fitness);
		
		return resultingChromosom;
		
	}
	
	private static VectorND getBestIndividual(Population pop) {
		VectorND bestVector = new VectorND(d);
		double bestFitness = 0;
		
		for(Chromosom chromosom : pop.population) {
			if(chromosom.getFitness() > bestFitness) {
				bestVector = IntervalEncoder.getInstance().getVectorFromChromosom(chromosom);
				bestFitness = chromosom.getFitness();
			}
		}
		
		return bestVector;
	}
}
