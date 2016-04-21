package de.dhbw.evol.util;

import java.util.ArrayList;
import java.util.List;

public class Vector6D {
	private List<Double> data;
	private double c = 2 * Math.PI;
	
	public Vector6D(double c) {
		data = new ArrayList<>(6);
		
		this.c = c;
	}
	
	public double getSquareSum() {
		double returnValue = 0.0f;
		
		for(Double element: data) {
			returnValue += element * element;
		}
		
		return returnValue;
	}
	
	public double getCosinusSum() {
		double returnValue = 0.0f;
		
		for(Double element : data) {
			returnValue += Math.cos(c * element);
		}
		
		return returnValue;
	}
}
