import java.text.DecimalFormat;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;

/*
 * It can be seen that the number, 125874, and its double, 251748, 
 * contain exactly the same digits, but in a different order.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, 
 * and 6x, contain the same digits.
 * 
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		boolean done = false;
		long x = 1;
		while(!done) {
			for(int multi = 6; multi >= 2; multi--) {
				
				long num = multi * x;
				String xStr = String.valueOf(x);
				String numStr = String.valueOf(num);
				if(numStr.length() != xStr.length()) {
					break;
				}
				
				if(!isPermutation(xStr,numStr)) {
					break;
				}
				
				if(multi == 2) {
					System.out.println(x);
					done = true;
				}	
			}
			x++;
		}
	}
	
	public static Set<String> getPermutations(String in) {
		Set<String> permutations = new HashSet<String>();
		permRecursive("", in, permutations);
		
		return permutations;
	}
	
	private static void permRecursive(String start, String left, Set<String> permutations) {
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
	
	public static boolean isPermutation(String in1, String in2) {
		
		Set<String> perms = getPermutations(in1);
		return perms.contains(in2);
	}
	
}