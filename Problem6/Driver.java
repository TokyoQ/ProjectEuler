public class Driver {
  public static void main(String[] args) {
  
	int sumSquares = 0;
	int sum = 0;
    for(int i = 1; i <= 100; i++) {
		sum += i;
		sumSquares += i * i;
	}
	System.out.println("The difference is: " + (sum*sum - sumSquares));
  }
}