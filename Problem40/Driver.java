import java.text.DecimalFormat;
import java.lang.StringBuilder;
import java.math.BigInteger;

/*
 * An irrational decimal fraction is created by concatenating the positive 
 * integers:
 * 
 * 0.123456789101112131415161718192021...
 * 
 * It can be seen that the 12th digit of the fractional part is 1.
 * 
 * If d_n represents the nth digit of the fractional part, find the value of 
 * the following expression.
 * 
 * d_1 × d_10 × d_100 × d_1000 × d_10000 × d_100000 × d_1000000
 * 
 */

public class Driver {

	public static void main(String[] args) throws Exception {
	
		StringBuilder sb = new StringBuilder();
		
		//Add all the numbers
		int i = 1;
		while(sb.length() <= 1000000) {
			sb.append(i);
			i++;
		}
		
		int prod = 1;
		int[] indices = {1, 10, 100, 1000, 10000, 100000, 1000000};
		for(int j = 0; j < indices.length; j++) {
			prod *= Integer.parseInt(sb.substring(indices[j] - 1, indices[j]));
		}
		
		System.out.println("The product is: " + prod);
	}
	
}