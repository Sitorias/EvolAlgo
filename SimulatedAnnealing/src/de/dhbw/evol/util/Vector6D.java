package de.dhbw.evol.util;

import java.util.ArrayList;
import java.util.List;

public class Vector6D {
	private List<Double> data;
	
	private final int dimension = 6;
	
	public Vector6D() {
		data = new ArrayList<>(6);
	}
	
	public double getSquareSum() {
		double returnValue = 0.0f;
		
		for(Double element: data) {
			returnValue += element * element;
		}
		
		return returnValue;
	}
	
	public double getCosinusSum(double c) {
		double returnValue = 0.0f;
		
		for(Double element : data) {
			returnValue += Math.cos(c * Math.PI * element);
		}
		
		return returnValue;
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public void setElementToValue(int index, double value) {
		this.data.set(index, value);
	}
	
	public double getElement(int index) {
		return this.data.get(index);
	}
}
