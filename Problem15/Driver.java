import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right 
 * and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 */

public class Driver {

	public static void main(String[] args) throws Exception {
	
		long[][] nums = new long[21][21];
		
		//Initialise top row and left column to 1
		for(int i = 0; i < 21; i++) {
			nums[0][i] = 1;
			nums[i][0] = 1;
		}
		
		//Iterate through matrix
		for(int i = 1; i < 21; i++) {
			for(int j = 1; j < 21; j++) {
				nums[i][j] = nums[i-1][j] + nums[i][j-1];
			}
		}
		
		System.out.println("The number of paths is: " + nums[20][20]);
		
	}
	
}