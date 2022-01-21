package junit.jupiter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JupiterTests {

	@Test
	@DisplayName("1 + 2 = 3")
	void test() {
		assertEquals(3, 1 + 5 - 3);
	}
}
