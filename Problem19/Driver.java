import java.text.DecimalFormat;
import java.math.BigInteger;

/*
 * You are given the following information, but you may prefer to do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		//Starts on Tuesday, in Jan
		int dayNum = 2;
		int monthNum = 0;
		int yearNum = 1900;
		int sundayCount = 0;
		
		int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		//Go for 100 years
		while(monthNum < 12*100) {
			dayNum += monthDays[monthNum%12];
			
			//Leap year case
			if(yearNum%4==0 && monthNum%12==1)
				dayNum++;
			
			if(monthNum%12==0)
				yearNum++;
			
			if(dayNum%7==0)
				sundayCount++;
			
			monthNum++;
		}
		
		System.out.println("The number of sundays is: " + sundayCount);
	}
	
}