import java.awt.*;
import java.awt.geom.*;

public class Paddle extends ColorShape{
	
	// location and size variables
	private static int speed;
	private static int xPos;
	private static final int yPos = 450;
	private static final int width = 60;
	private static final int height = 10;

	private static final Rectangle2D.Double shape = new Rectangle2D.Double(0,yPos,width,height);

	public Paddle() {
		super(shape);

		// set paddle color
		setFillColor(Color.BLUE);
		setBorderColor(Color.BLUE);

		// set paddle position and speed
		speed = 0;
		xPos = 275;
	}

	public void move() {
		// move paddle
		xPos += 2*speed;
		// stop the paddle from moving at the edges
		if (xPos <= 2) {
			xPos = 2;
		}

		if (xPos >= (600 - width)) {
			xPos = 600 - width;
		}
		// update shape
		shape.setRect(xPos, yPos, width, height);
	}

	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return xPos;
	}

	public Rectangle2D.Double getShape() {
		return shape;
	} 

}