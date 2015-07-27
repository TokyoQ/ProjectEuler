import java.text.DecimalFormat;
import java.lang.StringBuilder;
import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;

/*
 * In England the currency is made up of pound, £, and pence, p, and 
 * there are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * 
 * It is possible to make £2 in the following way:
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 
 * How many different ways can £2 be made using any number of coins?
 * 
 */

public class Driver {

	static int[] values = {1, 2, 5, 10, 20, 50, 100, 200};
	static int numCombos = 0;
	
	public static void main(String[] args) throws Exception {
	
		addValue(0, values.length -1);
		System.out.println("Total number of combinations: " + numCombos);
	}
	
	private static void addValue(int value, int index) {
		
		//Base case
		if(value == 200) {
			numCombos++;
			return;
		}
		
		for(int i = index; i >= 0; i--) {
			if(value + values[i] <= 200) {
				addValue(value + values[i], i);
			}
		}
	}
	
}