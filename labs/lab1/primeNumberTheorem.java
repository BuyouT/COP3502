public class primeNumberTheorem {
	public static void main(String args[]) {
		int num = Integer.parseInt(args[0]);
			//System.out.println("The ratio is " + primeRatio(num));
			if  (trialDivision(num)) {
				System.out.println("Your number is prime");
			}
		else {
			System.out.print("Your number is not prime");
		}
	}
	public static boolean trialDivision(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static int countPrimes(int n) {
		int count = 0;
		for (int i =1; i <= n; i++) {
			if (trialDivision(i)) {
				count++;
			}
		}
		return count;
	}
	public static double primeRatio(int n) {
		double estimate = n/Math.log(n);
		double density = countPrimes(n);
		return density/estimate;
	}
}


