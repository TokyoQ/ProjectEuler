import 	java.text.DecimalFormat;
import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;

/*
 * The number 3797 has an interesting property. Being prime itself, it is 
 * possible to continuously remove digits from left to right, and remain prime 
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to 
 * left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left 
 * to right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 */

public class Driver {

	private static int maxNum = 1000000;
	
	public static void main(String[] args) throws Exception {
		
		Set<Integer> primes = getPrimesLessThan(maxNum);
		
		//System.out.println("Number of primes below " + maxNum + ": " + primes.size());
		
		int numTrunctablePrimes = 0;
		int sum = 0;
		for(Integer num : primes) {
			if(num < 10)
				continue;
			
			//Truncating left to right
			String iStr = String.valueOf(num);
			boolean truncPrime = true;
			for(int i = 1; i < iStr.length(); i++) {
				String test = iStr.substring(i);
				if(!primes.contains(Integer.parseInt(test))) {
					truncPrime = false;
					break;
				}
			}
			
			//Truncating right to left
			for(int i = iStr.length()-1; i > 0; i--) {
				String test = iStr.substring(0,i);
				if(!primes.contains(Integer.parseInt(test))) {
					truncPrime = false;
					break;
				}
				
			}
			if(truncPrime) {
				//System.out.println(num);
				sum += num;
				numTrunctablePrimes++;
			}
		}
		
		System.out.println("Number of trunctable primes below " + maxNum + ": " + numTrunctablePrimes);
		System.out.println("The sum is: " + sum);
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