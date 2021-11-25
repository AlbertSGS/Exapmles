package chapter5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {

	private Stack<Object> aStack;

	@BeforeEach
	void setUp() {
		aStack = new Stack<>();
	}

	@Test
	void testPush() {
		Object o = new Object();
		aStack.push(o);
		assertFalse(aStack.isEmpty());
	}

}
