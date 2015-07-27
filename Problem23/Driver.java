import java.text.DecimalFormat;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;

/*
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to 
 * the number. For example, the sum of the proper divisors of 28 would be 
 * 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and it is 
 * called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that 
 * can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can 
 * be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. 
 * However, this upper limit cannot be reduced any further by analysis even though it is known that 
 * the greatest number that cannot be expressed as the sum of two abundant numbers is less than 
 * this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		Set<Integer> abundantNums = new HashSet<Integer>();
		
		//Find all abundant numbers up to 28123
		for(int i = 12; i <= 28123; i++) {
			if(isAbundant(i)) {
				abundantNums.add(Integer.valueOf(i));
			}
		}
		//System.out.println("There are " + abundantNums.size() + " abundant numbers below 28123.");
		
		long sum = 0;
		//For each of the numbers, check if it can be written as a sum of two abundant nums
		for(int i = 1; i <= 28123; i++) {
			
			boolean canBeDone = false;
			for(Integer j : abundantNums) {
				int diff = i - j;
				if(diff >= 0) {
					if(abundantNums.contains(Integer.valueOf(diff))) {
						canBeDone = true;
					}
				}
			}
			if(!canBeDone) {
				sum += i;
			}
		}
		
		System.out.println("The sum is: " + sum);
		
	}
	
	private static boolean isAbundant(int num) {
		int sum = 0;
		for(int i = 1; i <= num/2; i++) {
			//If i is proper divisor
			if(num % i == 0) {
				sum+= i;
			}
		}
		return sum > num;
	}
}