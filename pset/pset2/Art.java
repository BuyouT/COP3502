import java.awt.Color;

public class Art {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double x = .5;
		double y = .5;
		double rad = .5;
		drawArt(x, y, rad, n);
	}

	public static void filledCircle(double x, double y, double rad, Color c) {
		double xCoord = x;
		double yCoord = y;
		double radius = rad;
		StdDraw.setPenColor(c);
		StdDraw.filledCircle(x, y, rad);
	}

	public static void filledCircle2(double x, double y, double rad, Color c) {
		double xCoord = x;
		double yCoord = y;
		double radius = .05;
		StdDraw.setPenColor(c);
		StdDraw.filledCircle(x, y, .05);
	}

	public static void circle(double x, double y, double rad, Color c) {
		double xCoord = x;
		double yCoord = y;
		double radius = rad;
		StdDraw.setPenColor(c);
		StdDraw.circle(x, y, rad);
	}

	public static void drawArt(double x, double y, double rad, int n) {
		if (n==0) {
			return;
		}
		Color c = new Color(185, 76, 225);
		filledCircle(x, y, rad, c);
		Color a = new Color(0, 0, 0);
		circle(x, y, rad, a);
		filledCircle2(x, y, .05, a);
		drawArt(x, y, rad-.1, n-1);
	}
}