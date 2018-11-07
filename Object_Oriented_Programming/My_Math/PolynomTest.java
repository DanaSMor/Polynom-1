import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PolynomTest {

	Polynom p1 = new Polynom("2x^2 + 4x - 3");
	Polynom p2 = new Polynom("x^2 - 4x + 2");
	Polynom p3 = new Polynom("x^3 + 8X - 71");
	Polynom p4 = new Polynom("x^2 - 2x");
	Polynom p5 = new Polynom("4X + 5");
	Polynom p6 = new Polynom("2x^3 - 3");
	Polynom p7 = new Polynom("x^3 - 2x^2 + x - 1");
	Polynom p8 = new Polynom("8x^4 + 5");
	Polynom p9 = new Polynom("x^3 - 9");
	Polynom p10 = new Polynom("x^3 + 10");
	Polynom p11 = new Polynom("x - 1");
	Polynom p12 = new Polynom("x^2 - 3");
	Polynom p13 = new Polynom("x^5 - 3x^4 + x^3 - 5");
	Polynom p14 = new Polynom("x^2 - 1");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Start Polynom Test : \n");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("End Polynom Test");
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// Polynom p1 = new Polynom("2x^2 + 4x - 3");

	@Test
	void testPolynomString() {
		System.out.println("The first Tester : \n");
		Polynom check_ans = new Polynom();
		check_ans.add(new Monom("2x^2"));
		check_ans.add(new Monom("4x"));
		check_ans.add(new Monom("-3"));
		if (!p1.toString().equals(check_ans.toString()))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p2 = new Polynom("x^2 - 4x + 2");

	@Test
	void testF() {
		System.out.println("The second Tester : \n");
		if (p2.f(3) != -1)
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p3 = new Polynom("x^3 + 8X - 71");
	// Polynom p4 = new Polynom("x^2 - 2x");

	@Test
	void testAddPolynom_able() {
		System.out.println("The third Tester : \n");
		p3.add(p4);
		if (p3.toString().equals("+ 1.0*x^3 + 1.0*x^2 + 6.0*x^1 - 71.0"))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p5 = new Polynom("4X + 5");
	Monom check_one = new Monom("x^2");

	@Test
	void testAddMonom() {
		System.out.println("The fourth Tester : \n");
		p5.add(check_one);
		if (p5.toString().equals("+ 1.0*x^2 + 4.0*x^1 + 5.0"))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p6 = new Polynom("2x^3 - 3");
	// Polynom p7 = new Polynom("x^3 - 2x^2 + x - 1");

	@Test
	void testSubstract() {
		System.out.println("The fifth Tester : \n");
		p6.substract(p7);
		if (p6.toString().equals("+ 1.0*x^3 + 2.0*x^2 - 1.0*x^1 - 2.0"))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p8 = new Polynom("8x^4 + 5");
	// Polynom p9 = new Polynom("x^3 - 9");

	@Test
	void testMultiply() {
		System.out.println("The sixth Tester : \n");
		p8.multiply(p9);
		if (p8.toString().equals("+ 8.0*x^7 - 72.0*x^4 + 5.0*x^3 - 45.0"))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p10 = new Polynom("x^3 + 10");

	@Test
	void testEqualsPolynom_able() {
		System.out.println("The seventh Tester : \n");
		Polynom check_ans = new Polynom();
		check_ans.add(new Monom("x^3"));
		check_ans.add(new Monom("10"));
		if (!p10.equals(check_ans))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	@Test
	void testIsZero() {
		System.out.println("The eighth Tester : \n");
		Polynom check_ans = new Polynom("0");
		if (!check_ans.isZero())
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p11 = new Polynom("x - 1");

	@Test
	void testRoot() {
		System.out.println("The ninth Tester : \n");
		if (p11.root(-2, 2, 0.001) > 1.1 || p11.root(-2, 2, 0.001) < 0.9)
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p12 = new Polynom("x^2 - 3");

	@Test
	void testCopy() {
		System.out.println("The tenth Tester : \n");
		Polynom_able check_ans = p12.copy();
		if (check_ans.toString().equals("+ 1.0*x^2 - 3.0"))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p13 = new Polynom("x^5 - 3x^4 + x^3 - 5");

	@Test
	void testDerivative() {
		System.out.println("The eleventh Tester : \n");
		if (p13.derivative().toString().equals("+ 5.0*x^4 - 12.0*x^3 + 3.0*x^2"))
			fail("Not yet implemented");
		else {
			System.out.println("succeed , look for the next one \n");
		}
	}

	// Polynom p14 = new Polynom("x^2 - 1");

	@Test
	void testArea() {
		System.out.println("The twoelveth Tester : \n");
		if (p14.area(0, 2, 0.001) > 0.7 || p14.area(0, 2, 0.001) < 0.6)
			fail("Not yet implemented");
		else {
			System.out.println("succeed \n");
		}
	}

}
