import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;

/*
 * We shall say that an n-digit number is pandigital if it makes use of all 
 * the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital 
 * and is also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 */

public class Driver {

	static int maxPrime = 100000000;
	
	public static void main(String[] args) throws Exception {
		
		Set<Integer> primes = getPrimesLessThan(maxPrime);
		
		String number = "87654321";
		while(number.length() > 0) {
			ArrayList<String> pandigitals = getPermutations(number);
			
			for(int i = 0; i < pandigitals.size(); i++) {
				String num = pandigitals.get(i);
				if(primes.contains(Integer.parseInt(num))) {
					System.out.println(num);
					System.exit(0);
				}
			}
			
			number = number.substring(1);
		}
	}
	
	public static ArrayList<String> getPermutations(String in) {
		ArrayList<String> permutations = new ArrayList<String>();
		permRecursive("", in, permutations);
		
		return permutations;
	}
	
	private static void permRecursive(String start, String left, ArrayList<String> permutations) {
		//Base case
		if(left.length() == 0) {
			permutations.add(start);
			return;
		}
		for(int i = 0; i < left.length(); i++) {
			String newStart = start + left.charAt(i);
			String newLeft = left.substring(0,i) + left.substring(i+1);
			permRecursive(newStart, newLeft, permutations);
		}
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