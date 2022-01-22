package com.example.project;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimulationTests {
	Random rand = new Random();
	int rnd = rand.nextInt(3);


	@Test
	@DisplayName("ModuleTest")
	void crash() {
		Simu simulation = new Simu();
		assertEquals("lightImpact", simulation.airbags(rnd), "Module test");
	}
	@Test
	@DisplayName("ModuleTest")
	void steering() {
		Simu simulation = new Simu();
		assertEquals("braking", simulation.positioning(), "Module test");
	}

	@Test
	@DisplayName("ModuleTest")
	void acceleration() {
		Simu simulation = new Simu();
		assertEquals("keep", simulation.acceleration(), "Module test");
	}

	@Test
	@DisplayName("Method")
	void steerR() {
		Simu simulation = new Simu();
		assertEquals("steerLeft", simulation.right(), "Module test");
	}

	@Test
	@DisplayName("Method")
	void ignition() {
		Simu simulation = new Simu();
		assertEquals(1, simulation.ignition(), "Module test");
	}

	@Test
	@DisplayName("Method")
	void allowDrive() {
		Simu simulation = new Simu();
		assertEquals("DriverInTruck", simulation.allowDrive(), "Module test");
	}

	@Test
	@DisplayName("Method")
	void selftest() {
		Simu simulation = new Simu();
		assertEquals(1, simulation.selftest(), "Module test");
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

