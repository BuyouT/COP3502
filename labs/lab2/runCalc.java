public class runCalc {
	public static void main (String[] args) {
		Calculator myCalc = new Calculator();
		
		myCalc.add("5", "10");
		myCalc.substract(14.2, 3.6);
		myCalc.multiply(8, 3.5);
		System.out.println(myCalc.add("5", "10"));
		System.out.println(myCalc.substract(14.2, 3.6));
		System.out.println(myCalc.multiply(8, 3.5));

	}
}