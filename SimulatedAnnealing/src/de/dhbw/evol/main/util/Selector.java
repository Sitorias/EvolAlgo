package de.dhbw.evol.main.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.crypto.KeySelector.Purpose;

public final class Selector {
	public static Population selectFromPopulation(Population population) {
		List<Chromosom> survivingIndividuals = new ArrayList<>();
		
		int popsize = population.population.size() / 7;
		
		List<Double> probabilityToSurviveForChromosom = new ArrayList<Double>();
		
		double sumFitness = 0;
		
		for(Chromosom chromosom : population.population) {
			sumFitness += chromosom.getFitness();
		}
		
		for(Chromosom chromosom : population.population) {
			double probabilityToSurvive = chromosom.getFitness() / sumFitness;
			
			probabilityToSurviveForChromosom.add(probabilityToSurvive);
		}		
		
		List<Double> remainingProbability = new ArrayList<>();
		
		for(int i = 0; i < probabilityToSurviveForChromosom.size(); i++) {
			probabilityToSurviveForChromosom.set(i, probabilityToSurviveForChromosom.get(i) * popsize);
			
			while(probabilityToSurviveForChromosom.get(i) > 1.0) {
				survivingIndividuals.add(population.population.get(i));
				probabilityToSurviveForChromosom.set(i, probabilityToSurviveForChromosom.get(i) - 1);
			}
			
			remainingProbability.set(i, probabilityToSurviveForChromosom.get(i));
		}
		
		double sumProbabilities = 0;
		
		for(double probability : remainingProbability) {
			sumProbabilities += probability;
		}
		
		for(double probability : remainingProbability) {
			probability = probability / sumProbabilities;
		}
		
		for(int i = survivingIndividuals.size(); i < popsize; i++) {
			int indexToAdd = Evolution.getInstance().getRandomIntInInterval(population.population.size());
			
			survivingIndividuals.add(population.population.get(indexToAdd));
		}
		
		Population resultingPopulation = new Population();
		resultingPopulation.population = survivingIndividuals;
		return resultingPopulation;
	}
}
