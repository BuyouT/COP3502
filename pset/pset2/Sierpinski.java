public class Sierpinski {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double x = .5;
		double y = 0;
		double len = .5;
		double h = len*Math.sin((Math.PI)/3);
		drawSierpinski(x, y, len, n);
	}	
		
	public static void filledTriangle(double x, double y, double len) {
		double [] xCoord = {x,x-len/2,x+len/2};
		double [] yCoord = {y,y+len*Math.sin((Math.PI)/3),y+len*Math.sin((Math.PI)/3)};
		StdDraw.filledPolygon(xCoord, yCoord);
	}


	public static void drawSierpinski(double x, double y, double len, int n) {
		if (n == 0) {
			return;
		}
		filledTriangle(x, y, len);
		drawSierpinski(x, y + len*Math.sin((Math.PI)/3), len/2, n-1);
		drawSierpinski(x-len/2, y, len/2, n-1);
		drawSierpinski(x+len/2, y, len/2, n-1);
	}
}