public class primeNumberTheorem {
	public static void main(String args[]) {
		int num = Integer.parseInt(args[0]);
		if (trialDivision(num)) {
			System.out.println("Your number is prime.");
		}
		else {
			System.out.println("Your number is not prime.");
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
}

