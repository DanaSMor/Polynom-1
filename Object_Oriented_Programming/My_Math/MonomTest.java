import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonomTest {

	Monom m1 = new Monom("3x^2");
	Monom m2 = new Monom("2x");
	Monom m3 = new Monom("4");
	Monom m4 = new Monom("-2x");
	Monom m5 = new Monom("x^5");
	Monom m6 = new Monom("x^2");
	Monom m7 = new Monom("4x^2");
	Monom m8 = new Monom("7x");
	Monom m9 = new Monom("3x^4");
	Monom m10 = new Monom("2x^4");
	Monom m11 = new Monom("x");
	Monom m12 = new Monom("3x");
	Monom m13 = new Monom("5");
	Monom m14 = new Monom("9x^2");
	Monom m15 = new Monom("x^6");
	Monom m16 = new Monom("x^7");
	Monom m17 = new Monom("81x^2");
	Monom m18 = new Monom("47x");
	Monom m19 = new Monom("9x");
	Monom m20 = new Monom("9");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Start Monom Test \n");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("End Monom Test");
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// Monom m1 = new Monom("3x^2");
	// Monom m2 = new Monom("2x");

	@Test
	void testMonomDoubleInt() {
		System.out.println("The first Tester : \n");
		int ans_pow = m1.get_power();
		double ans_coef = m1.get_coefficient();
		int ans_pow2 = m2.get_power();
		double ans_coef2 = m2.get_coefficient();
		if ((ans_pow != 2 && ans_coef != 3) && (ans_pow2 != 0 && ans_coef2 != 2))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Monom m3 = new Monom("4");
	// Monom m4 = new Monom("-2x");

	@Test
	void testMonomMonom() {
		System.out.println("The second Tester : \n");
		Monom check_monom = new Monom(m3);
		Monom check_monom2 = new Monom(m4);
		if (check_monom.get_coefficient() != 4 || check_monom.get_power() != 0 || check_monom2.get_coefficient() != -2
				|| check_monom2.get_power() != 1)
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Monom m5 = new Monom("x^5");

	@Test
	void testMonomString() {
		System.out.println("The third Tester : \n");
		Monom check_monom = new Monom(1, 5);
		if (m5.get_coefficient() != check_monom.get_coefficient() || m5.get_power() != check_monom.get_power())
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Monom m6 = new Monom("x^2");
	// Monom m7 = new Monom("4x^2");

	@Test
	void testAdd() {
		System.out.println("The fourth Tester : \n");
		m6.add(m7);
		if (m6.get_coefficient() != 5 || m6.get_power() != 2)
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Monom m8 = new Monom("7x");

	@Test
	void testDerivative() {
		System.out.println("The fifth Tester : \n");
		m8 = m8.derivative();
		if (m8.get_coefficient() != 7 || m8.get_power() != 0)
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Monom m9 = new Monom("3x^4");

	@Test
	void testF() {
		System.out.println("The sixth Tester : \n");
		if (m9.f(2) != 48)
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Monom m10 = new Monom("2x^4");
	// Monom m11 = new Monom("x");

	@Test
	void testMultiply() {
		System.out.println("The seventh Tester : \n");
		m10.multiply(m11);
		if (m10.get_coefficient() != 2 || m10.get_power() != 5)
			fail("Not yet implemented");
		else {
			System.out.println("succeed");
		}
	}

}
