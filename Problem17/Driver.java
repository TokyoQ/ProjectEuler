import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, 
 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written 
 * out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and 
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 
 * 20 letters. The use of "and" when writing out numbers is in compliance with 
 * British usage.
 * 
 */

public class Driver {

	public static void main(String[] args) throws Exception {
	
		int letters = 0;
		int[] lastDigLetters = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
		int[] secondDigLetters = {0, 0, 6, 6, 5, 5, 5, 7, 6, 6};
		//Check all the numbers
		for(int i = 0; i < 1000; i++) {
			
			//Nums which end in 1x or x(0-9)
			int lastTwo = i % 100;
			if(lastTwo < lastDigLetters.length){
				letters += lastDigLetters[lastTwo]; 
			} else {
				int lastDigit = lastTwo % 10;
				letters += lastDigLetters[lastDigit];
			}
			
			int secondDigit = (i/10)%10;
			letters += secondDigLetters[secondDigit];
			
			//Hundreds
			if(i >= 100) {
				letters += 7;
				if(i % 100 != 0)
					letters += 3;
			}
			
			int firstDigit = i/100;
			letters += lastDigLetters[firstDigit];
		}
		letters += 11;
		System.out.println("The number of letters is: " + letters);
		
	}
	
}