public class Driver {
  public static void main(String[] args) {
  
	int num1 = 1;
	int num2 = 1;
	int sum = 0;
	
	/* sum not correct */
	
	while(num1 <= 4000000) {
		if(num1 % 2 == 0) {
			sum += num1;
		}
		int temp = num1;
		num1 += num2;
		num2 = temp;
	}
	System.out.println();
	System.out.println("The sum is: " + sum);
  }
}