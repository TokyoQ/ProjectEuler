import java.text.DecimalFormat;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * By starting at the top of the triangle below and moving to adjacent numbers on the row 
 * below, the maximum total from top to bottom is 23.
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from a 100 row triangle.
 * 
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		int[][] nums = new int[100][100];
		int[][] sums = new int[100][100];
		
		//Get numbers from file
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		int lineNum = 0;
		while((line = br.readLine()) != null) {
			String[] tokens = line.split("\\s");
			for(int i = 0; i <= lineNum; i++) {
				nums[lineNum][i] = Integer.parseInt(tokens[i]);
			}
			lineNum++;
		}
		
		sums = copy(nums);
		//Start at the bottom and use max algorithm
		for(int i = lineNum-2; i >=0; i--) {
			for(int j = 0; j < i+1; j++) {
				if(sums[i+1][j] >= sums[i+1][j+1]) {
					sums[i][j] += sums[i+1][j];
				} else {
					sums[i][j] += sums[i+1][j+1];
				}
			}
		}

		System.out.println("The total sum is " + sums[0][0]);
	}
	
	private static int[][] copy(int[][] matrix){
		
		int[][] result = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				result[i][j] = matrix[i][j];
			}
		}
		return result;
	}
}