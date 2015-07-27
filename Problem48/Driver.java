import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * 
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		BigInteger sum = BigInteger.ZERO;
		for(int i = 1; i <= 1000; i++) {
			sum = sum.add(power(i));
		}
		
		System.out.println("The sum is: " + sum);
	}
	
	private static BigInteger power(int num) {	
		BigInteger result = BigInteger.ONE;
		
		for(int i = 0; i < num; i++) {
			result= result.multiply(BigInteger.valueOf(num));
		}
		return result;
	}
}