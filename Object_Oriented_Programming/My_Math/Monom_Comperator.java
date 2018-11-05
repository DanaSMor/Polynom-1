import java.util.Comparator;

/**
 * This class help to arrange the Polynom according the powers of the Monoms.
 * 
 * @author Lioz and Nahama
 *
 */
public class Monom_Comperator implements Comparator<Monom> {
	@Override
	public int compare(Monom arg0, Monom arg1) {
		if (arg0.get_power() > arg1.get_power()) {
			return -1;
		} else {
			if (arg0.get_power() < arg1.get_power()) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
