import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral 
 * is formed as follows:
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the 
 * same way?
 */

public class Driver {

	static final int RIGHT = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int UP = 3;
	
	static int dir;
	static int x;
	static int y;
	
	public static void main(String[] args) throws Exception {
	
		//Generate the array
		int[][] nums = new int[1001][1001];

		x = 500;
		y = 500;
		int steps = 1;
		int moveCount = 0;
		int changeDirCount = 0;
		dir = RIGHT;
		
		for(int i = 1; i <= 1001*1001; i++) {
			nums[x][y] = i;
			move();
			moveCount++;
			
			if(moveCount == steps) {
				dir = nextDir();
				moveCount = 0;
				changeDirCount++;
				
			}
			if(changeDirCount == 2) {
				changeDirCount = 0;
				steps++;
			}
		}
		
		//Calculate the diagonal sums
		long sum = 0;
		for(int i = 0; i < 1001; i++) {
			sum += nums[i][i];
			sum += nums[1000-i][i];
		}
		sum -= nums[500][500];
		
		System.out.println("The sum is: " + sum);
	}
	
	private static int nextDir() {
		switch(dir) {
		case RIGHT:
			return DOWN;
		case DOWN:
			return LEFT;
		case LEFT:
			return UP;
		case UP:
			return RIGHT;
		}
		return dir;
	}
	
	private static void move() {
		switch(dir) {
		case RIGHT:
			x++;
			break;
		case DOWN:
			y++;
			break;
		case LEFT:
			x--;
			break;
		case UP:
			y--;
			break;
		}
	}
	
}