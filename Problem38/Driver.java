import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;

/*
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * 
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * 
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 
 * 192384576 the concatenated product of 192 and (1,2,3)
 * 
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving 
 * the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * 
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated 
 * product of an integer with (1,2, ... , n) where n > 1?
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		int bestPand = -1;
		for(int i = 2; i < 10000; i++) {
			String num = "";
			int multiplier = 1;
			
			while(num.length()  < 9) {
				num += String.valueOf(i*multiplier);
				multiplier++;
			}
			
			//Check pandigital
			if(isPandigital(num)) 
				if(Integer.valueOf(num) > bestPand) 
					bestPand = Integer.valueOf(num);
		}
		System.out.println(bestPand);
	}
	
	//Checks if the number n is 1-9 pandigital
	private static boolean isPandigital(String num) {
		
		if(num.length() != 9) {
			return false;
		}
		
		if(!num.contains("1") || !num.contains("2") || !num.contains("3") || !num.contains("4")
			|| !num.contains("5") || !num.contains("6") || !num.contains("7") || !num.contains("8")
			|| !num.contains("9") ) {
				return false;
			}
		return true;
	}
	
	private static boolean isPandigital(int n) {
		String num = String.valueOf(n);
		return isPandigital(num);
	}
}