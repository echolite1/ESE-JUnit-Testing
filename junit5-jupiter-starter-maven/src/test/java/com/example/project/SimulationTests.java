package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimulationTests {

	@Test
	@DisplayName("Module")
	void simpleTest() {
		Simu simulation = new Simu();
		assertEquals("steerLeft", simulation.right(), "Module test");
	}

	@ParameterizedTest(name = "Status Report")
	@CsvSource({
			"0, IgnitionOn",
			"1, SelftestOk",
			"2, Follower",
			"3, FollowingInProgress"
	})
	void cruising(int test, String expectedResult) {
		Simu sim = new Simu();
		assertEquals(expectedResult, sim.cruise(test), "Status Report test");
	}
}

