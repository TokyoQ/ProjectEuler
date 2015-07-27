import 	java.text.DecimalFormat;
import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;

/*
 * Euler discovered the remarkable quadratic formula:
 * 
 * n^2 + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive 
 * values n = 0 to 39. However, when n = 40, 40^2 + 40 + 41 = 40(40 + 1) + 41 
 * is divisible by 41, and certainly when n = 41, 41^2 + 41 + 41 is clearly 
 * divisible by 41.
 * 
 * The incredible formula  n^2 − 79n + 1601 was discovered, which produces 
 * 80 primes for the consecutive values n = 0 to 79. The product of the 
 * coefficients, −79 and 1601, is −126479.
 * 
 * Considering quadratics of the form:
 * 
 * n^2 + a*n + b, where |a| < 1000 and |b| < 1000
 * 
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |−4| = 4
 * 
 * Find the product of the coefficients, a and b, for the quadratic expression 
 * that produces the maximum number of primes for consecutive values of n, starting 
 * with n = 0.
 * 
 */

public class Driver {

	private static int maxNum = 1000000;
	
	public static void main(String[] args) throws Exception {
		
		//Get all primes up to a certain number
		Set<Integer> primes = getPrimesLessThan(maxNum);
		
		int bestStreak = 0;
		int bestA = 0;
		int bestB = 0;
		for(int a = -999; a < 1000; a++) {
			for(int b = -999; b < 1000; b++) {
				
				boolean prime = true;
				int n = 0;
				int streak = 0;
				while(prime) {
					int testNum = n*n + a*n + b;
					if(testNum > maxNum)
						System.out.println("You didn't make it high enough!");
					n++;
					
					if(primes.contains(testNum)) 
						streak++;
					else
						prime = false;
					
				}
				if(streak > bestStreak) {
					bestStreak = streak;
					bestA = a;
					bestB = b;
					//System.out.println("Best so far, a: " + a + ", b: " + b + ", streak = " + streak);
				}
			}
		}
		System.out.println("Best streak is: " + bestStreak + " with a = " + bestA + " and b = " + bestB);
		System.out.println("The product is: " + bestA*bestB);
	}
	
	public static Set<Integer> getPrimesLessThan(int n) {
		
		Set<Integer> primes = new HashSet<Integer>();
		boolean[] marked = new boolean[n];
		
		for(int i = 2; i < n; i++) {
			if(!marked[i]) {
				primes.add(i);
				
				//Mark all multiples of i
				for(int j = i; j < n; j+=i) {
					marked[j] = true;
				}
			}
		}
		return primes;
	}
	
	
	
}