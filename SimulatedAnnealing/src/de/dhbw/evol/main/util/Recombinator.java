package de.dhbw.evol.main.util;

public final class Recombinator {

	public static Population recombinate(Population pop, int genLen){
		for (int i=0; i < pop.population.size(); i++){
			int point1 = Evolution.getInstance().getRandomIntInInterval(genLen);
			int point2 = Evolution.getInstance().getRandomIntInInterval(genLen);
			while (point1 == point2){
				point2 = Evolution.getInstance().getRandomIntInInterval(genLen);
			}
			int start = Math.max(point1, point2);
			int end = Math.min(point1, point2);
			
			for (int j = start; j < end; j++){
				pop.population.get(i).content[j] = pop.population.get(i+1).content[j];
				pop.population.get(i+1).content[j] = pop.population.get(i).content[j];
			}
		}
		return pop;
	}
}
