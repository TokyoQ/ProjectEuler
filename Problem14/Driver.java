import java.text.DecimalFormat;

/*
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class Driver {

	static int bestChainLength = 0;
	static int chainLength = 0;
	
	public static void main(String[] args) throws Exception {
		
		long bestStart = 0;
		
		for(long i = 1; i <= 1000000; i++) {
			chainLength = 0;
			seq(i);
			
			if(chainLength > bestChainLength) {
				bestChainLength = chainLength;
				bestStart = i;
			}
		}
		
		System.out.println("The best start num is: " + bestStart);
		System.out.println("The best chain length is: " + bestChainLength);
	}
	
	private static void seq(long i) {
		
		//Base case
		while(i > 1) {
			//System.out.println(i);
			chainLength++;
			if(i%2 == 0)
				i = i/2;
			else
				i = 3*i + 1;
			
			if(i < 1)
				System.out.println("Weird error! i = " + i);
		}
		chainLength++;
	}
}