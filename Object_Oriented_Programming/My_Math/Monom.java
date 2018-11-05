
import java.lang.Math;

/**
 * This class represents a simple "Monom" of shape a*x^b, 
 * where a is a real number and a is an integer (summed a none negative), 
 * The class implements function and support simdple operations as:
 * construction, value at x, derivative, add and multiply. 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * @author Lioz and Nahama
 *
 */
public class Monom implements function {

	private double _coefficient;
	private int _power;

	public Monom(double a, int b)
	{
		if (b > 0)
		{
			this.set_coefficient(a);
			this.set_power(b);
		}

		if (b == 0)
		{
			this.set_coefficient(a);
		}

		if (b < 0)
		{
			throw new IllegalArgumentException("exponent cannot be negative: " + b);
		}
	}

	/**
	 * A copy constructor
	 * @param other represent an other Polynom
	 */
	public Monom(Monom ot) 
	{
		this(ot.get_coefficient(), ot.get_power());
	}

	/**
	 * A constractor that gets a string
	 * Monoms from the format a*x^b / ax / a / x / x^b
	 * when a is a decimal number that represent the coefficient, 
	 * and b is a natural (not negative) number that represent the power.
	 * @param s represent a String of Monom
	 */
	public Monom(String s)
	{
		if (s == null || s.isEmpty())
		{
			throw new IllegalArgumentException("exponent cannot be empty ");
		}

		else
		{
			s = s.toLowerCase();
			int indexof_multy = s.indexOf('*');
			int indexof_x = s.indexOf('x');
			int indexof_pow = s.indexOf('^');

			if (!s.contains("x") && !s.contains("X"))
			{
				set_power(0);
				set_coefficient(Double.parseDouble(s));
			}
			else if(s.equals("x"))
			{
				set_coefficient(1);
				set_power(1);
			}
			else
			{
				if (s.contains("*") && s.contains("^")) 
				{
					set_coefficient(Double.parseDouble(s.substring(0, indexof_multy)));
					set_power(Integer.parseInt(s.substring(indexof_pow + 1, s.length())));
				}
				if (s.contains("*") && !s.contains("^")) 
				{
					set_power(1);
					set_coefficient(Double.parseDouble(s.substring(0, indexof_multy)));
				}
				if (s.contains("^") && !s.contains("*"))
				{
					set_power(Integer.parseInt(s.substring(indexof_pow + 1, s.length())));
					if (s.substring(0, indexof_x).isEmpty()) 
					{
						set_coefficient(1);
					} else
					{
						set_coefficient(Double.parseDouble(s.substring(0, indexof_x)));
					}
				}
				if (!s.contains("^") && !s.contains("*"))
				{
					set_coefficient(Double.parseDouble(s.substring(0, indexof_x)));
					set_power(1);
				}
			}
		}
	}


	/**
	 * This function update the coefficient
	 * @param a represent a decimal number
	 */
	private void set_coefficient(double a)
	{
		this._coefficient = a;
	}

	/**
	 * This function update the coefficient
	 * @param p represent a natural number (not negative)
	 */
	private void set_power(int p)
	{
		if (p >= 0)
			this._power = p;
		else 
			throw new RuntimeException("invalid input, the power can't be negative ");
	}

	/**
	 * This function gets coefficient
	 * @return the coefficient
	 */
	public double get_coefficient() 
	{
		return _coefficient;
	}

	/**
	 * This function gets power
	 * @return the power
	 */
	public int get_power()
	{
		return _power;
	}

	/**
	 * @return String that represent the monom data.
	 */
	@Override
	public String toString()
	{
		if (_power > 0) 
		{
			return (_coefficient + "*" + "x^" + _power);
		} else 
		{
			return ("" + _coefficient);
		}
	}

	/**
	 * This function add a new monom to our monom , if they have the same power otherwise its print error messege
	 * @param other represent the monom that we want to add to our monom.
	 */ 
	public void add(Monom other)
	{
		if (other.get_power() == this._power)
		{
			set_coefficient(other.get_coefficient() + this._coefficient);
		} else
		{
			System.err.println("EROR: The powers are not the same, they can't be add");
		}
	}
	/**
	 * The function does a derivative act on our monom
	 * @return a Monom after doing  derivative .
	 */
	public Monom derivative() 
	{
		Monom ans;
		if (get_power() != 0)
		{
			ans = new Monom(_coefficient * _power, _power - 1);
		} else
		{
			ans = new Monom("0");
		}
		return ans;
	}
	/**
	 * the function calculate the y value of this monom 
	 * @param x Represents the position on the x axis
	 * @return the y value of this monom
	 */
	public double f(double x) 
	{
		double y = (get_coefficient()) * (Math.pow(x, get_power()));
		return y;
	}
	/**
	 * the fanction multiplyed our monom by a new monom ( after multiplying our monom data will be change to the multiplyed monom) 
	 * @param a Represents a monom that going to multiply with our monom
	 * @return our monom after being multiplyed by a monom
	 */
	public Monom multiply(Monom a)
	{
		this._coefficient = (a._coefficient * _coefficient);
		this._power = (a._power + _power);
		return this;
	}
}
