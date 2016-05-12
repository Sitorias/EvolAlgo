package de.dhbw.evol.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.evol.main.util.VectorND;

public class VectorNDTest {

	@Test
	public void vectorWithDimension6ShouldContain6ZeroValues() {
		final int dimension = 6;
		
		VectorND vectorToTest = new VectorND(dimension);
		
		for(int i = 0; i < dimension; i++) {
			assertEquals(0.0, vectorToTest.getElement(i), 10E-5);
		}
	}

}
