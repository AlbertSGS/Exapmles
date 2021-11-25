package chapter5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinTest {

	@Test
	void testMin_Positive_MinBefore() {
		assertEquals(2, Math.min(2, 5));
	}

	@Test
	void testMin_Positive_MinAfter() {
		assertEquals(4, Math.min(7, 4));
	}

	@Test
	void testMin_Positive_Equal() {
		assertEquals(3, Math.min(3, 3));
	}

	@Test
	void testMin_Negative_MinBefore() {
		assertEquals(-4, Math.min(-4, -2));
	}

	@Test
	void testMin_Negative_MinAfter() {
		assertEquals(-3, Math.min(-2, -3));
	}

	@Test
	void testMin_Negative_Equal() {
		assertEquals(-2, Math.min(-2, -2));
	}

	@Test
	void testMin_Mixed_MinBefore() {
		assertEquals(-2, Math.min(-2, 3));
	}

	@Test
	void testMin_Mixed_MinAfter() {
		assertEquals(-3, Math.min(1, -3));
	}

}
