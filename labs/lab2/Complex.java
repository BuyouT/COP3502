public class Complex {
	double real;
	double imag;
	public Complex (double r, double i) {
		real = r;
		imag = i;
	}	
		public Complex add(Complex n) {
			double r = real + n.real;
			double i = imag + n.imag;
			Complex sum = new Complex(r, i);
			return sum;
		}
		public Complex multiply(Complex n) {
			double r = (real * n.real) - (imag * n.imag);
			double i = (real * n.imag) + (imag * n.real);
			Complex product = new Complex(r, i);
			return product;
		}
		public double abs(Complex n) {
			double r = real*real;
			double i = imag*imag;
			double absValue = Math.sqrt(r + i);
			return absValue;
		}
		public String toString() {
			String cnum = real + " + " + imag + "i";
			return cnum;
		}
}