package de.dhbw.evol.util;
import de.dhbw.evol.util.Vector6D;


public class Fitness {
	double a,b,c,d;
	
	public Fitness(double a, double b, double c, int d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public double getFitness(Vector6D parVec){
		double fitness = 0;
		
		fitness = - a*Math.pow(Math.E, (-b*Math.sqrt((1/d)*parVec.getSquareSum())));		
		fitness -= Math.pow(Math.E, (1/d)*parVec.getCosinusSum(c));		
		fitness += a;		
		fitness += Math.E;
		
		return fitness;
	}
}
