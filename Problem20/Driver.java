import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * Find the sum of the digits in the number 100!
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		BigInteger result = fact(100);
		String resultStr = result.toString();
		System.out.println("100! = " + resultStr);
		
		int sum = 0;
		for(int i = 0; i < resultStr.length(); i++) {
			String digitStr = resultStr.substring(i,i+1);
			int digit = Integer.parseInt(digitStr);
			sum += digit;
		}
		System.out.println();
		System.out.println("The sum of the digits in 100! is: " + sum);
		
	}
	
	private static BigInteger fact(int num) {
		BigInteger fact = BigInteger.ONE;
		
		for(int i = num; i > 1; i--) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}
}