package de.dhbw.evol.main.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Selector {
	public static Population selectFromPopulation(Population population) {
		List<Chromosom> survivingIndividuals = new ArrayList<>();
		
		float popsize = population.population.size() / 7;
		
		Map<Chromosom, Double> probabilityToSurviveForChromosom = new ConcurrentHashMap<>();
		
		double sumFitness = 0;
		
		for(Chromosom chromosom : population.population) {
			sumFitness += chromosom.getFitness();
		}
		
		for(Chromosom chromosom : population.population) {
			double probabilityToSurvive = chromosom.getFitness() / sumFitness;
			
			probabilityToSurviveForChromosom.put(chromosom, probabilityToSurvive);
		}		
		
		Map<Chromosom, Double> remainingProbability = new ConcurrentHashMap<>();
		
		for(Chromosom chromosom : probabilityToSurviveForChromosom.keySet()) {
			double probability = probabilityToSurviveForChromosom.get(chromosom) * popsize;
			
			while(probability > 1.0) {
				survivingIndividuals.add(chromosom);
				probability--;
			}
			
			remainingProbability.put(chromosom, probability);
		}
		
		double sumProbabilities = 0;
		
		for(double probability : remainingProbability.values()) {
			sumProbabilities += probability;
		}
		
		for(double probability : remainingProbability.values()) {
			probability = probability / sumProbabilities;
		}
		
		Population resultingPopulation = new Population();
		resultingPopulation.population = survivingIndividuals;
		return resultingPopulation;
	}
}
