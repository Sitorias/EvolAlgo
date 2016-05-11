package de.dhbw.evol.main.util;

public final class Mutator {
	
	public static Population mutate(Population pop, double chance, int genLen){
		for (Chromosom chromosom : pop.population){
			double randomNumber = Evolution.getInstance().getRandomNumberInInterval(0, 1);
			if (randomNumber <= chance){
				int mutPos = Evolution.getInstance().getRandomIntInInterval(genLen);
				if (chromosom.content[mutPos]=='0'){
					chromosom.content[mutPos]='1';
				} else {
					chromosom.content[mutPos]='0';
				}
			}
		}
		
		return pop;
	}
}
