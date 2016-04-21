package de.dhbw.evol.util;

import java.util.Random;

/**
 * 
 * @author phillipp
 *	This class will evolve the vectors with random values
 */
public class Evolution {
	private static Evolution instance;
	
	Random randomGenerator;
	
	private Evolution() {
		this.randomGenerator = new Random();
	}
	
	public static synchronized Evolution getInstance() {
		return instance;
	}
	
//	public Vector6D generateRandomVector() {
//		Vector
//		
//		for()
//	}
}
