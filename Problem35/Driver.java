import 	java.text.DecimalFormat;
import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;

/*
 * The number, 197, is called a circular prime because all rotations of the digits: 
 * 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 */

public class Driver {

	private static int maxNum = 1000000;
	
	public static void main(String[] args) throws Exception {
		
		Set<Integer> primes = getPrimesLessThan(maxNum);
		
		System.out.println("Number of primes below " + maxNum + ": " + primes.size());
		
		int numCirclePrimes = 0;
		for(Integer i : primes) {
			//Get circle permutations
			Set<String> cycles = getCircular(String.valueOf(i));
			
			//Check if all circular combinations are prime
			boolean allPrime = true;
			for(String s : cycles) {
				if(!primes.contains(Integer.parseInt(s))) {
					allPrime = false;
					break;
				}
				
			}
			if(allPrime)
				numCirclePrimes++;
		}
		
		System.out.println("Number of circular primes below " + maxNum + ": " + numCirclePrimes);
	}
	
	public static Set<String> getCircular(String in) {
		
		Set<String> circles = new HashSet<String>();
		for(int i = 0; i < in.length(); i++) {
			circles.add(in);
			in = in.charAt(in.length()-1) + in.substring(0,in.length()-1);
		}
		return circles;
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