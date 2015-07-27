import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which 
 * is correct, is obtained by cancelling the 9s.
 * 
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * 
 * There are exactly four non-trivial examples of this type of fraction, less 
 * than one in value, and containing two digits in the numerator and denominator.
 * 
 * If the product of these four fractions is given in its lowest common terms, 
 * find the value of the denominator.
 * 
 */

public class Driver {

	static int totNum = 1;
	static int totDen = 1;
	
	public static void main(String[] args) throws Exception {
		
		for(double num = 10; num < 100; num++) {
			
			int firstDig = Integer.valueOf(String.valueOf(num).substring(0,1));
			int secondDig = Integer.valueOf(String.valueOf(num).substring(1,2));
			
			if(secondDig == 0)
				continue;
			
			//Check first digit
			for(int i = 1; i < 10; i++) {
				double den = Double.valueOf(i + String.valueOf(firstDig));
				if(num >= den)
					continue;
				
				double frac = num/den;
				if(secondDig/(double)i == frac) {
					//System.out.println(num + "/" + den);
					lowestFrac(num,den);
				}
			}
			
			//Check second digit
			for(int i = 1; i < 10; i++) {
				double den = Double.valueOf(String.valueOf(secondDig) + i);
				if(num >= den)
					continue;
				
				double frac = num/den;
				if(firstDig/(double)i == frac) {
					//System.out.println(num + "/" + den);
					lowestFrac(num,den);
				}
			}
		}
		
		double lowestDen = lowestDenom(totNum, totDen);
		System.out.println("The lowest denominator is: " + lowestDen);
	}
	
	public static void lowestFrac(double num, double den) {
		
		boolean done = false;
		while(!done) {
			int hcf = findHCF((int)num,(int)den);
			if(hcf < 0)
				break;
			
			num = num / hcf;
			den = den / hcf;
		}
		totNum *= num;
		totDen *= den;
	}

	public static double lowestDenom(double num, double den) {
		
		boolean done = false;
		while(!done) {
			int hcf = findHCF((int)num,(int)den);
			if(hcf < 0)
				break;
			
			num = num / hcf;
			den = den / hcf;
		}
		return den;
	}
	
	//Finds the highest common factor of a and b
	public static int findHCF(int a, int b) {
		
		int max = a;
		if(b > a)
			max = b;
		
		for(int i = max; i > 1; i--) {
			if(a % i == 0 && b % i == 0)
				return i;
		}
		return -1;
	}
}