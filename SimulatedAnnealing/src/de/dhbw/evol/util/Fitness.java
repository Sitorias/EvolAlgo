package de.dhbw.evol.util;
import de.dhbw.evol.util.Vector6D;


public class Fitness {
	double a,b,c,d;
	
	public Fitness(double a, double b, double c, double d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public double getFitness(Vector6D parVec){
		double fitness;
		
		fitness = a*Math.pow(Math.E, (-b*parVec.getSquareSum())
				- Math.pow(Math.E, (1/d)*parVec.getCosinusSum(c))
				+a+Math.E);
		
		return fitness;
	}
}
