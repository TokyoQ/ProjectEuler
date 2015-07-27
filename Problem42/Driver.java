import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * The nth term of the sequence of triangle numbers is given by, t_n = 0/5*n(n+1); 
 * so the first ten triangle numbers are:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * By converting each letter in a word to a number corresponding to its alphabetical 
 * position and adding these values we form a word value. For example, the word value 
 * for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we 
 * shall call the word a triangle word.
 * 
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing 
 * nearly two-thousand common English words, how many are triangle words?
 * 
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		//Get names from file
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String[] tokens = line.split("\"");
		String[] words = new String[tokens.length/2];
		
		for(int i = 0; i < words.length; i++) {
			words[i] = tokens[2*i+1];
		}
		
		//Generate triangle numbers
		ArrayList<Integer> triangles = getTriangles(1000);
		int maxTriangle = triangles.get(triangles.size()-1);
		
		//Go through the names
		int numTriangles = 0;
		for(int i = 0; i < words.length; i++) {
			int score = getScore(words[i]);
			if(score > maxTriangle)
				System.out.println("You didn't make it large enough!");
			if(triangles.contains(score))
				numTriangles++;
		}
		
		System.out.println("There are " + words.length + " words in the list.");
		System.out.println("There are " + numTriangles + " triangle words in the list.");
	}
	
	private static int getScore(String name) {
		
		name = name.toLowerCase();
		int sum = 0;
		for(int i = 0; i<name.length(); i++) {
			int ch = (int)name.charAt(i);
			sum += ch - 96;
		}
		return sum;
	}
	
	//Returns a set containing the first n triangle numbers
	private static ArrayList<Integer> getTriangles(int n) {
		
		ArrayList<Integer> triangles = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++) {
			triangles.add(i*(i+1)/2);
		}
		return triangles;
		
	}
	
}