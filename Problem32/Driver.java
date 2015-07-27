import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;

/*
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 
 * 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, 
 * multiplier, and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity can be 
 * written as a 1 through 9 pandigital.
 * 
 * HINT: Some products can be obtained in more than one way so be sure to only include it 
 * once in your sum.
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		String numbers = "987654321";
		ArrayList<String> pandigitals = getPermutations(numbers);
		Set<Integer> products = new HashSet<Integer>();
		
		int sum = 0;
		for(String number : pandigitals) {
			for(int mult = 1; mult <= 7; mult++) {
				for(int equals = mult+1; equals <= 8; equals++) {
					
					int multiplicand = Integer.parseInt(number.substring(0,mult));
					int multiplier = Integer.parseInt(number.substring(mult, equals));
					int product = Integer.parseInt(number.substring(equals));
					
					//System.out.println(multiplicand + "x" + multiplier + "=" + product + "?");
					
					if(multiplicand * multiplier == product) {
						if(!products.contains(product)) {
							sum += product;
							products.add(product);
						}
					}
				}
			}
		}
		
		System.out.println("The sum is: " + sum);
		
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
	
}