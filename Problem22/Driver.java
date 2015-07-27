import java.text.DecimalFormat;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file 
 * containing over five-thousand first names, begin by sorting it into alphabetical 
 * order. Then working out the alphabetical value for each name, multiply this value 
 * by its alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 
 * 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a 
 * score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		//Get names from file
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String[] tokens = line.split("\"");
		String[] names = new String[tokens.length/2];
		
		for(int i = 0; i < names.length; i++) {
			names[i] = tokens[2*i+1];
		}
		
		//Order the names
		Arrays.sort(names);
		
		
		//Go through the names
		long sum = 0;
		for(int i = 0; i < names.length; i++) {
			sum += (i+1) * getScore(names[i]);
		}
		
		System.out.println("The sum is: " + sum);
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
	
}