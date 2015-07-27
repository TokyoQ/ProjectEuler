import java.text.DecimalFormat;
import java.lang.Math;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;

/*
 * Surprisingly there are only three numbers that can be written as the sum of 
 * fourth powers of their digits:
 * 
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * 
 * As 1 = 14 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		long bigSum = 0;
		for(long i = 2; i <= 1000000; i++) {
			String num = String.valueOf(i);
			double sum = 0;
			for(int j = 0; j < num.length(); j++){
				sum += Math.pow(Integer.parseInt(num.substring(j,j+1)), 5);
			}
			if(i == sum) {
				bigSum += i;  }
		}
		
		System.out.println("The sum is: " + bigSum);
	}
}