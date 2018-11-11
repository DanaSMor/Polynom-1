
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import java.lang.Math;

/**
 * This interface represents a general Polynom: f(x) = a_1X^b_1 + a_2*X^b_2 ...
 * a_n*Xb_n This class represents a Polynom with add, multiply functionality, it
 * also should support the following: 1. Riemann's Integral:
 * https://en.wikipedia.org/wiki/Riemann_integral 2. Finding a numerical value
 * between two values (currently support root only f(x)=0). 3. Derivative
 * 
 * We used the following sites: https://www.geeksforgeeks.org
 * https://stackoverflow.com https://github.com https://www.java-forums.org
 * 
 * @author Lioz and Nahama
 *
 */
public class Polynom implements Polynom_able {

	private ArrayList<Monom> poly;

	/**
	 * A defaultiv constructor
	 */
	public Polynom() {
		poly = new ArrayList<>(0);
	}

	/**
	 * A constractor that gets a string Polynom from the format a*x^b + a*x^b -
	 * a*x^b.... when a is a decimal number that represent the coefficient, and b is
	 * a natural (not negative) number that represent the power.
	 * 
	 * @param s represent a String of Polynom
	 */
	public Polynom(String s)
	{
		poly = new ArrayList<Monom>();
		s = s.toLowerCase();
		s = s.replaceAll(" ", "");
		s = s.replaceAll("-", "+-");
		String[] new_s = s.split("\\+");
		if (new_s.length>1 && new_s[0].isEmpty())
		{
			for (int i = 1; i < new_s.length; i++)
			{
				add(new Monom(new_s[i]));
			}
		}
		else
		{
			for (int i = 0; i < new_s.length; i++)
			{
				add(new Monom(new_s[i]));
			}
		}

		Monom_Comperator s_c = new Monom_Comperator();
		this.poly.sort(s_c);
	}

	/**
	 * This interface represents a simple function of type y=f(x), where both y and
	 * x are real numbers.
	 * 
	 * @param x represent a real number
	 * @return y=f(x)
	 */
	@Override
	public double f(double x) {
		double ans = 0;
		Iterator<Monom> iter = poly.iterator();
		while (iter.hasNext()) {
			Monom runner = iter.next();
			ans = ans + runner.f(x);
		}
		return ans;
	}

	/**
	 * This function add the Polynom p1 to this Polynom. The function uses a
	 * iterator and is aided by the function add that received a Monom.
	 * 
	 * @param p1 represent a Ponynom_able that we want to add
	 */
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> iter = p1.iteretor();
		while (iter.hasNext()) {
			Monom runner = iter.next();
			add(runner);
		}

	}

	/**
	 * This function add the Monom m1 to this Polynom. The function uses a itarator
	 * and a variable 'flag' to chack if the Monom has been added, the iterator goes
	 * over all the Polynom and add the Monom m1 to the Monom with the same power,
	 * if there is no Monom with the same power the Monom m1 will be added in the
	 * end.
	 * 
	 * @param m1 represent a Monom that we want to add
	 */
	@Override
	public void add(Monom m1) {
		Iterator<Monom> iter = iteretor();
		while (iter.hasNext() && !poly.isEmpty()) {
			Monom runner = iter.next();
			if (runner.get_power() == m1.get_power()) {
				runner.add(new Monom(m1));
				return;
			}
		}
		poly.add(new Monom(m1));
		Monom_Comperator s_c = new Monom_Comperator();
		this.poly.sort(s_c);
	}

	/**
	 * This function subtract the Polynom p1 from this Polynom, The function uses a
	 * iterator that goes over all the Polynom p1, create a new Monom with a minus
	 * before the coefficient, and add every Monom to this Polynom.
	 * 
	 * @param p1 represent a Polynom_able that we want to subtract
	 */
	@Override
	public void substract(Polynom_able p1) {
		Iterator<Monom> iter = p1.iteretor();
		while (iter.hasNext()) {
			Monom runner = iter.next();
			this.add(new Monom(0 - runner.get_coefficient(), runner.get_power()));
		}
	}

	/**
	 * This function multiply this Polynom by the Polynom p1. The function uses 2
	 * iterators, one for each Polynom. it multiply every Monom from this Polynom by
	 * the Polynom p1.
	 * 
	 * @param p1 represent a Polynom_able that we want to multiply
	 */
	@Override
	public void multiply(Polynom_able p1) {
		Polynom ans = new Polynom();
		Iterator<Monom> iter = iteretor();
		while (iter.hasNext()) {
			Monom runner = iter.next();
			Iterator<Monom> iter2 = p1.iteretor();
			while (iter2.hasNext()) {
				Monom runner2 = iter2.next();
				ans.add(runner.multiply(runner2));
			}
		}
		poly.clear();
		this.poly = ans.poly;
	}

	/**
	 * The function test if this Polynom is logically equals to p1. The function
	 * uses 2 iterators, one for each Polynom, and check if the Monoms are equals.
	 * 
	 * @param p1 represent a Polynom_able that we want to compare to
	 * @return true iff this pulynom represents the same function ans p1
	 */
	@Override
	public boolean equals(Polynom_able p1) {
		if (p1 == null) {
			throw new IllegalArgumentException("exponent cannot be null");
		}
		double x = (Math.random() * 10000);
		if (f(x) == p1.f(x)) {
			Iterator<Monom> iter1 = poly.iterator();
			Iterator<Monom> iter2 = p1.iteretor();
			while (iter1.hasNext() && iter2.hasNext()) {
				Monom runner1 = iter1.next();
				Monom runner2 = iter2.next();
				if (runner1.get_coefficient() != runner2.get_coefficient()
						&& runner1.get_power() != runner2.get_power()) {
					return false;
				}
			}
			if (!iter1.hasNext() && !iter2.hasNext())
			// Checking if both of the Polynoms don't have more Monoms
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * The function test if this is the Zero Polynom. The function uses a iterator
	 * that goes over all the Polynom and check if the coefficient is 0.
	 * 
	 * @return true if this is the Zero Polynom
	 */
	@Override
	public boolean isZero() {
		if (this.poly != null) {
			Iterator<Monom> iter = poly.iterator();
			while (iter.hasNext()) {
				Monom runner = iter.next();
				if (runner.get_coefficient() != 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This function finds the point (x') of intersection of the polynom on the x
	 * axis (f(x')=0) between two points (one under the x axis and one above the x
	 * axis). the function uses a recursion method.
	 * 
	 * @param x0  represent a starting point
	 * @param x1  represent a end point
	 * @param eps represent the step (positive) value
	 * @return the x' found
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		if (f(x0) * f(x1) > 0) {
			throw new IllegalArgumentException("exponent cannot be calculate ");
		} else {
			double middle = (x1 + x0) / 2;
			if (Math.abs(f(middle)) < eps) {
				return middle;
			}
			if (f(x0) == 0) {
				return x0;
			}
			if (f(x1) == 0) {
				return x1;
			}
			if (f(middle) < 0) {
				x0 = middle;
			} else if (f(middle) > 0) {
				x1 = middle;
			}
		}
		return root(x0, x1, eps);
	}

	/**
	 * This function create a deep copy of this Polynum The function uses a iterator
	 * that goes over all the Polynom and copy evry Monom to a new Polynom.
	 * 
	 * @return the new Polynom which is a copy
	 */
	@Override
	public Polynom_able copy() {
		Polynom_able ans = new Polynom();
		Iterator<Monom> iter = poly.iterator();
		while (iter.hasNext()) {
			Monom runner = iter.next();
			ans.add(runner);
		}
		return ans;
	}

	/**
	 * This function compute a new Polynom which is the derivative of this Polynom.
	 * The function uses a iterator that goes over all the Polynom and do a
	 * derivative for each Monom.
	 * 
	 * @return the derivative of this Polynom.
	 */
	@Override
	public Polynom_able derivative() {
		Polynom ans = new Polynom();
		Iterator<Monom> iter = iteretor();
		while (iter.hasNext()) {
			ans.add(iter.next().derivative());
		}
		return ans;
	}

	/**
	 * This function compute Riemann's Integral over this Polynom starting from x0,
	 * till x1 using eps size steps, We used:
	 * https://en.wikipedia.org/wiki/Riemann_integral
	 * 
	 * @return the approximated area above the x-axis below this Polynom and between
	 *         the [x0,x1] range.
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		double ans = 0;
		double i = 0;
		for (i = x0; i < x1; i = i + eps) {
			double y = i + (eps / 2);
			ans = ans + (f(y) * eps);
		}
		return ans;
	}

	/**
	 * This function create an Iterator (of Monoms) over this Polynom_able
	 * 
	 * @return the iterator
	 */
	@Override
	public Iterator<Monom> iteretor() {
		Iterator<Monom> iter = poly.iterator();
		return iter;
	}

	/**
	 * This function create a String of this Polynom. The function uses a iterator
	 * that goes over all the Polynom and uses the toString of each Monom.
	 * 
	 * @return a String of this Polynom
	 */
	@Override
	public String toString() {
		String Polinom = "";
		for (int i = 0; i < this.poly.size(); i++) {
			if (poly.get(i).get_coefficient() > 0) {
				Polinom += " + " + this.poly.get(i).toString();
			}
			if (poly.get(i).get_coefficient() < 0) {
				Monom m = new Monom(poly.get(i).get_coefficient() * (-1), poly.get(i).get_power());
				Polinom += " - " + m.toString();
			}

		}
		return Polinom;
	}
//testgit
	public double Maximum(double x0, double x1, Polynom p) {
		double start = root(x0, x1, 0.001);
		double end = x1;
		double Max = f(x1);

		if (start == end)
			return f(start);
		if (f(start) > f(end))
			Max = start;
		else {
			Max = end;
		}

		return f(Max);
	}

	public double Minimum(double x0, double x1, Polynom p) {
		double start = root(x0, x1, 0.001);
		double end = x1;
		double Min = f(x0);

		if (start == end)
			return f(Min);
		if (f(Min) > f(end))
			Min = end;
		
		return Minimum(start, end, p);
	}

}