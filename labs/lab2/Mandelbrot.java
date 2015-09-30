import java.awt.Color;

public class Mandelbrot {
	public static void main(String[] args) {
		double centerX = Double.parseDouble(args[0]);
		double centerY = Double.parseDouble(args[1]);
		double size = Double.parseDouble(args[2]);
		int N = 512;
		Picture pic = new Picture(N,N);
		for (int x =0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				double x0 = centerX - (size/2) + (x * size)/N;
				double y0 = centerY - (size/2) + (y * size)/N;
				Complex c = new Complex(x0,y0);
				Complex z = new Complex (0,0);
				int gray = 0;
				for (int i = 0; i < 255; i++) {
					if (z.abs() > 2.0) break;
						z = z.multiply(z).add(c);
						gray++;
				}
				pic.set(x,y, new Color(255-gray,255-gray,255-gray));
			}
		}
		pic.show();

	}
}