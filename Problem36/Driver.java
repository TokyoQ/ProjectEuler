import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * The decimal number, 585 = 1001001001_2 (binary), is palindromic in both bases.
 * 
 * Find the sum of all numbers, less than one million, which are palindromic in 
 * base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 * 
 */

public class Driver {

	public static void main(String[] args) throws Exception {
	
		int sum = 0;
		for(int i = 0; i < 1000000; i++) {
			String bin = Integer.toBinaryString(i);
			String dec = Integer.toString(i);
			if(isPalindrome(bin) && isPalindrome(dec))
				sum += i;
		}
		System.out.println("The sum is: " + sum);
	}
	
	private static boolean isPalindrome(String in) {
		for(int i = 0; i < (in.length()+1)/2; i++){
			if (in.charAt(i) != in.charAt(in.length() - (i+1)))
				return false;
		}
		return true;
	}
}