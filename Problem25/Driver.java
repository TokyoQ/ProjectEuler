import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 */

public class Driver {

	private static BigInteger fib1 = BigInteger.ONE;
	private static BigInteger fib2 = BigInteger.ONE;
	private static boolean even = true;
	
	private static int num = 2;
	
	public static void main(String[] args) throws Exception {
		
		boolean done = false;
		while(!done) {
			
			fib();
			BigInteger testee;
			if(even) {
				testee = fib2;
			} else {
				testee = fib1;
			}
			
			if(testee.toString().length() >= 1000) {
				done = true;
			}
		}
		System.out.println("The first Fibonacci term with more than 1000 digits is: " + num);
		System.out.println();
		System.out.print("F_" + num + " = ");
		if(even) {
			System.out.println(fib2);
		} else {
			System.out.println(fib1);
		}
	}
	
	private static void fib() {
		num++;
		if(even) {
			fib1 = fib1.add(fib2);
			even = false;
		} else {
			fib2 = fib2.add(fib1);
			even = true;
		}
	}
}