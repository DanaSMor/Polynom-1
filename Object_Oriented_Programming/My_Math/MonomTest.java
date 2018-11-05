import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	void testMonomDoubleInt() {
		Monom m1 = new Monom(2, 1);
		if (m1.get_coefficient() != 2 && m1.get_power() != 1) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testMonomMonom() {
		Monom m1 = new Monom(2, 1);
		fail("Not yet implemented");
	}

	@Test
	void testMonomString() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}

}
