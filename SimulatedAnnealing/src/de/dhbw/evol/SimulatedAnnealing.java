package de.dhbw.evol;

import de.dhbw.evol.util.Evolution;
import de.dhbw.evol.util.Fitness;
import de.dhbw.evol.util.VectorND;

public class SimulatedAnnealing {
	private static final double a = 20;
	private static final double b = 0.2;
	private static final double c = 2 * Math.PI;
	private static final int d = 2;

	public SimulatedAnnealing() {
	}

	public static void main(String[] args) {
		Fitness myFitness = new Fitness(a, b, c, d);

		VectorND parameterVector = Evolution.getInstance().generateRandomVector(d);
		double temperature = 1;
		double coolingRate = 0.001;
		double temperatureWeight = 0.0001;
		double intervallBorderWeight = 10;
		int operationBorder = 1000;

		double fitnessValueOld = myFitness.getFitness(parameterVector);

		while (temperature > 0.001) {
			int noOperationHappened = 0;

			while (noOperationHappened < operationBorder) {
				parameterVector = Evolution.getInstance().updateNElementsOfVectorWithStep(1, parameterVector, temperature * intervallBorderWeight);

				double fitnessValueNew = myFitness.getFitness(parameterVector);

				double differenceFitness = fitnessValueNew - fitnessValueOld;

				if (differenceFitness < 0) {
					fitnessValueOld = fitnessValueNew;
				} else {
					double randomNumber = Evolution.getInstance().getRandomNumberInInterval(0, 1);

					double controlValue = Math.exp(-differenceFitness / temperatureWeight * temperature);

					if (randomNumber < controlValue) {
						fitnessValueOld = fitnessValueNew;
						noOperationHappened = 0;
					} else {
						noOperationHappened++;
					}
				}
			}

			temperature *= 1 - coolingRate;
		}

		System.out.println(fitnessValueOld);
	}

}
