
public class Test {
//testgit
	public static void main(String[] args) {

		// --------------- Monom tester ----------------
//
//		
//		
//		Monom m = new Monom("2x^2");
//
//		Monom new_copy_one = new Monom(m);
//
//		Monom n = new Monom(2, 2);
//
//		System.out.println("This is the Monom m: " + m.toString());
//		System.out.println("This is the Monom new_copy_one: " + new_copy_one.toString());
//		System.out.println("This is the Monom n: " + n.toString());
//
//		n.add(m);
//		System.out.println(m + " + 2*x^2 (n)= " + n.toString());
//
//		Monom t = n.derivative();
//		System.out.println("The derivative of " + n + " is: " + t.toString());
//
//		System.out.println("ans for f(2): " + m.f(2)); // for f(double a) function
//
//		Monom w = m.multiply(n);
//		System.out.println("2*x^2 * " + n + " = " + w.toString());
//
//		// --------------- Polynom tester ----------------
//
//		
//		
//		Polynom p1 = new Polynom("x^2 - 2x + 1");
//		Polynom p3 = new Polynom();
//		Monom m1 = new Monom("x^3");
//		Monom m2 = new Monom(2, 2);
//
//		System.out.println("This is the Polynom p1: " + p1.toString());
//		System.out.println("This is the Polynom p3: " + p3.toString());
//
//		System.out.println("ans for f(4) : " + p1.f(4));
//
//		Polynom p2 = new Polynom("2x + 1");
//		p1.add(p2);
//		System.out.println("p1 + p2 = " + p1.toString());
//
//		p1.add(m1);
//		p2.add(m2);
//		System.out.println(m1 + " m1 add to p1 : " + p1.toString());
//		System.out.println(m2 + " m2 add to p2 : " + p2.toString());
//
//		Polynom p4 = new Polynom("5x^3 + 2x + 1");
//		Polynom p5 = new Polynom("2x^2 + 1");
//		System.out.println("This is the Polynom p4: " + p4.toString());
//		p4.substract(p5);
//		System.out.println(p5 + "p5 substract from the Polynom p4: " + p4.toString());
//
//		Polynom p6 = new Polynom("x^2 + x");
//		Polynom p7 = new Polynom("2x + 1");
//		p6.multiply(p7);
//		System.out.println("The ans should be : 2x^3 + 3x^2 + x ->" + p6.toString());
//
//		Polynom p8 = new Polynom("x^2 + x");
//		Polynom p9 = new Polynom("2x + 1");
//		System.out.println("The ans should be no -->" + p8.equals(p9));
//
//		Polynom p10 = new Polynom("0");
//		System.out.println("The ans should be yes -->" + p10.isZero());
//
//		Polynom p11 = new Polynom("x^2 - 2");
//		System.out.println("The ans should be : sqrt(2) -->" + p11.root(-1, 3, 0.001));
//
//		Polynom p12 = new Polynom("x^2 - 2x + 1");
//		Polynom_able p13 = p12.copy();
//		System.out.println("This is the Polynom should be : x^2 - 2x + 1 --> " + p13.toString());
//
//		Polynom p14 = new Polynom("x^2 - 2x + 1");
//		System.out.println("The ans should be : 2x - 2 --> " + p14.derivative().toString());
//
//		Polynom p15 = new Polynom("x^2");
//		System.out.println("The ans should be : 80.9999 --> " + p15.area(-6, 3, 0.001));
		
		Polynom p14 = new Polynom("x^2 - 1");
		System.out.println(p14.area(0, 2, 0.001));
	}

}