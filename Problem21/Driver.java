import java.text.DecimalFormat;
import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;

/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n 
 * which divide evenly into n).
 * 
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and 
 * each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class Driver {

	public static void main(String[] args) throws Exception {
	
		int maxNum = 20000;
		
		int[] d = new int[maxNum];
		Set<Integer> amicableNums = new HashSet<Integer>();
		
		//Calc d for all values
		for(int i = 1; i < maxNum; i++) {
			d[i] = sumDivisors(i);
		}
		
		//Check all values with all other values
		for(int i = 1; i < maxNum; i++) {
			
			if(! amicableNums.contains((Integer)i)) {
				for(int j = 1; j < maxNum; j++) {
					if(d[i] == j && d[j] == i && i != j) {
						amicableNums.add((Integer)i);
						amicableNums.add((Integer)j);
						//System.out.println(i + "," + j);
					}
				}
			}
		}
		long sum = 0;
		for(int i = 1; i < 10000; i++) {
			if(amicableNums.contains((Integer)i))
				sum += i;
		}
		System.out.println("The sum is: " + sum);
	}
	
	private static int sumDivisors(int num) {
		int sum = 0;
		for(int i = 1; i <= num/2; i++) {
			//If i is proper divisor
			if(num % i == 0) {
				sum+= i;
			}
		}
		return sum;
	}
	
}