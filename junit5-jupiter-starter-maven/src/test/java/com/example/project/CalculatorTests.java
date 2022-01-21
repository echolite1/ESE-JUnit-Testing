package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	@Test
	@DisplayName("1 = decelerate")
	void simpleTest() {
		Calculator calculate = new Calculator();
		assertEquals(10, calculate.cruise(1), "1 = decelerate to 10");
	}

	@ParameterizedTest(name = "distance keeping")
	@CsvSource({
			"0,    0", 		// error
			"1,    10", 	// too close
			"10,   5"		// too far, 5 is the optimal
	})
	void cruising(int first, int expectedResult) {
		Calculator calculate = new Calculator();
		assertEquals(expectedResult, calculate.cruise(first), () -> first + " should equal " + expectedResult);
	}

	@ParameterizedTest(name = "obstacle avoiding")
	@CsvSource({
			"right,    		left", 			// avoid to left
			"left,    		right", 		// avoid to left
			"straight,   	braking" 		// unavoidable, brake
	})
	void steering(String first, String expectedResult) {
		Calculator calculate = new Calculator();
		assertEquals(expectedResult, calculate.steer(first), () -> first + " should equal " + expectedResult);
	}

	@ParameterizedTest(name = "communication")
	@CsvSource({
			"goodRequest,    connected", 		// avoid to left
			"badRequest,    not able to connect", 		// avoid to left
			"lalala,   input error" 	// unavoidable, brake
	})
	void communicate(String first, String expectedResult) {
		Calculator calculate = new Calculator();
		assertEquals(expectedResult, calculate.communicate(first), () -> first + " should equal " + expectedResult);
	}
}
class Simulation{
	
}
