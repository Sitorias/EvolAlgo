package de.dhbw.evol.main.util;

public final class Mutator {
	
	public static Population mutate(Population pop, double chance, int genLen){
		for (Chromosom chromosom : pop.population){
			for (int i = 0; i < genLen; i++) { 
				double randomNumber = Evolution.getInstance().getRandomNumberInInterval(0, 1);
				if (randomNumber <= chance){
					if (chromosom.content[i]==0){
						chromosom.content[i]=1;
					} else {
						chromosom.content[i]=0;
					}
				}
			}
			
		}
		return pop;
	}
}
