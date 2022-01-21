package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimulationTests {

	@Test
	@DisplayName("Module")
	void steerR() {
		Simu simulation = new Simu();
		assertEquals("steerLeft", simulation.right(), "Module test");
	}

	@Test
	@DisplayName("Module")
	void ignition() {
		Simu simulation = new Simu();
		assertEquals(1, simulation.ignition(), "Module test");
	}

	@Test
	@DisplayName("Module")
	void allowDrive() {
		Simu simulation = new Simu();
		assertEquals("DriverInTruck", simulation.allowDrive(), "Module test");
	}

	@Test
	@DisplayName("Module")
	void selftest() {
		Simu simulation = new Simu();
		assertEquals(1, simulation.selftest(), "Module test");
	}

	@Test
	@DisplayName("Module")
	void acceleration() {
		Simu simulation = new Simu();
		assertEquals("idle", simulation.acceleration(), "Module test");
	}

	@Test
	@DisplayName("Module")
	void steering() {
		Simu simulation = new Simu();
		assertEquals("braking", simulation.steering(), "Module test");
	}

	@ParameterizedTest(name = "Status Report Positive")
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

