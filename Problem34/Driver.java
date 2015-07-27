import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		long curiousSum = 0;
		for(long i = 3; i < 100000; i++) {
			
			int sum = 0;
			String iStr = String.valueOf(i);
			for(int j = 0; j < iStr.length(); j++) {
				int digit = Integer.parseInt(iStr.substring(j,j+1));
				sum += fact(digit);
			}
			if(sum == i) {
				curiousSum += i;
				System.out.println(i + " is curious.");
			}
		}
		
		System.out.println("The sum is: " + curiousSum);
	}
	
	private static int fact(int n) {
		if(n==1 || n== 0)
			return 1;
		else
			return n*fact(n-1);
	}
}