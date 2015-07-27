public class Useful {

	public static int[][] copy(int[][] matrix){
		
		int[][] result = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				result[i][j] = matrix[i][j];
			}
		}
		return result;
	}
	
	public static BigInteger fact(int num) {
		BigInteger fact = BigInteger.ONE;
		
		for(int i = num; i > 1; i--) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}
	
	public static int fact(int n) {
		if(n==1 || n== 0)
			return 1;
		else
			return n*fact(n-1);
	}
	
	public static int sumProperDivisors(int num) {
		int sum = 0;
		for(int i = 1; i <= num/2; i++) {
			//If i is proper divisor
			if(num % i == 0) {
				sum+= i;
			}
		}
		return sum;
	}
	
	public static boolean isAbundant(int num) {
		int sum = sumProperDivisors(num);
		return sum > num;
	}
	
	public static boolean isPalindrome(String in) {
		for(int i = 0; i < (in.length()+1)/2; i++){
			if (in.charAt(i) != in.charAt(in.length() - (i+1)))
				return false;
		}
		return true;
	}
	
	public static Set<String> getPermutations(String in) {
		Set<String> permutations = new HashSet<String>();
		permRecursive("", in, permutations);
		
		return permutations;
	}
	
	private static void permRecursive(String start, String left, Set<String> permutations) {
		//Base case
		if(left.length() == 0) {
			permutations.add(start);
			return;
		}
		for(int i = 0; i < left.length(); i++) {
			String newStart = start + left.charAt(i);
			String newLeft = left.substring(0,i) + left.substring(i+1);
			permRecursive(newStart, newLeft, permutations);
		}
	}
	
	public static Set<String> getCircular(String in) {
		
		Set<String> circles = new HashSet<String>();
		for(int i = 0; i < in.length(); i++) {
			circles.add(in);
			in = in.charAt(in.length()-1) + in.substring(0,in.length()-1);
		}
		return circles;
	}
	
	public static Set<Integer> getPrimesLessThan(int n) {
		
		Set<Integer> primes = new HashSet<Integer>();
		boolean[] marked = new boolean[n];
		
		for(int i = 2; i < n; i++) {
			if(!marked[i]) {
				primes.add(i);
				
				//Mark all multiples of i
				for(int j = i; j < n; j+=i) {
					marked[j] = true;
				}
			}
		}
		return primes;
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
}