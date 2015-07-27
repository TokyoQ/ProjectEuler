import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * If p is the perimeter of a right angle triangle with integral length sides, 
 * {a,b,c}, there are exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		int maxCount = -1;
		int bestPerimeter = -1;
		for(int i = 3; i <= 1000; i++) {
			int count = getRightTriangles(i);
			if(count > maxCount) {
				maxCount = count;
				bestPerimeter = i;
			}
		}
		
		System.out.println("The best perimeter is: " + bestPerimeter + 
				" with " + maxCount + " integral triangles.");
		
	}
	
	//Gets the number of integral length right sided triangles with perimeter p
	private static int getRightTriangles(int p) {
		
		int count = 0;
		for(double a = 1; a < p-2; a++) {
			for(double b = 1; b < p-2; b++) {
				
				double hypot = p - a - b;
				if(a*a + b*b == hypot*hypot)
					count++;
			}
		}
		return count;
	}
	
}