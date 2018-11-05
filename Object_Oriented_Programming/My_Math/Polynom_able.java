
import java.util.Iterator;

/**
 * This interface represents a general Polynom: f(x) = a_1X^b_1 + a_2*X^b_2 ... a_n*Xb_n
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * We used the following sites: 
 * https://www.geeksforgeeks.org
 * https://stackoverflow.com
 * https://github.com
 * https://www.java-forums.org
 * 
 * @author Lioz and Nahama
 *
 */
public interface Polynom_able extends cont_function{
	/**
	 * This function add the Polynom p1 to this Polynom.
	 * The function uses a iterator and is aided by the function add that received a Monom.
	 * @param p1 represent a Ponynom_able that we want to add
	 */
	public void add(Polynom_able p1);
	/**
	 * This function add the Monom m1 to this Polynom.
	 * The function uses a itarator and a variable 'flag' to chack if the Monom has been added,
	 * the iterator goes over all the Polynom and add the Monom m1 to the Monom with the same power,
	 * if there is no Monom with the same power the Monom m1 will be added in the end.
	 * @param m1 represent a Monom that we want to add
	 */
	public void add(Monom m1);
	/**
	 * This function subtract the Polynom p1 from this Polynom, 
	 * The function uses a iterator that goes over all the Polynom p1,
	 * create a new Monom with a minus before the coefficient, and add every Monom to this Polynom.
	 * @param p1 represent a Polynom_able that we want to subtract
	 */
	public void substract(Polynom_able p1);
	/**
	 * This function multiply this Polynom by the Polynom p1.
	 * The function uses 2 iterators, one for each Polynom.
	 * it multiply every Monom from this Polynom by the Polynom p1.
	 * @param p1 represent a Polynom_able that we want to multiply
	 */
	public void multiply(Polynom_able p1);
	/**
	 * The function test if this Polynom is logically equals to p1.
	 * The function uses 2 iterators, one for each Polynom, and check if the Monoms are equals.
	 * @param p1 represent a Polynom_able that we want to compare to
	 * @return true iff this pulynom represents the same function ans p1
	 */
	public boolean equals (Polynom_able p1);
	/**
	 * The function test if this is the Zero Polynom.
	 * The function uses a iterator that goes over all the Polynom and check if the coefficient is 0.
	 * @return true if this is the Zero Polynom
	 */
	public boolean isZero();
	/**
	 * This function finds the point (x') of intersection of the polynom on the x
	 * axis (f(x')=0) between two points (one under the x axis and one above the x axis).
	 * the function uses a recursion method.
	 * @param x0  represent a starting point
	 * @param x1  represent a end point
	 * @param eps represent the step (positive) value
	 * @return the x' found
	 */
	public double root(double x0, double x1, double eps);
	/**
	 * This function create a deep copy of this Polynum
	 * The function uses a iterator that goes over all the Polynom and copy evry Monom to a new Polynom.
	 * @return the new Polynom which is a copy
	 */
	public Polynom_able copy();
	/**
	 * This function compute a new Polynom which is the derivative of this Polynom.
	 * The function uses a iterator that goes over all the Polynom and do a derivative for each Monom.
	 * @return the derivative of this Polynom.
	 */
	public Polynom_able derivative();
	/**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
	 * see: https://en.wikipedia.org/wiki/Riemann_integral
	 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
	 */
	public double area(double x0,double x1, double eps);
	/**
	 * This function create an Iterator (of Monoms) over this Polynom_able
	 * @return the iterator 
	 */
	public Iterator<Monom> iteretor();
}
