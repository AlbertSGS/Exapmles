package chapter5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AbsTest {

	@Test
	void testAbs_Zero() {
		assertEquals(0, Math.abs(0));
	}

	@Test
	void testAbs_Positive() {
		assertEquals(1, Math.abs(1));
	}

	@Test
	void testAbs_Negative() {
		assertEquals(2, Math.abs(-2));
	}

}
