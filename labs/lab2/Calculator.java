public class Calculator {
		public static int add(String num1, String num2) {
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			int sum = n1 + n2;
			return sum;
		}
		public static double substract(double x, double y) {
			double difference = x - y;
			return difference;
		}
		public static double multiply(double x, double y) {
			double product = x * y;
			return product;
		}

}
