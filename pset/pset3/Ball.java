import java.awt.geom.*;
import java.awt.*;

public class Ball extends ColorShape {
	
	// location and size variables
	private int xPos;
	private int yPos;
	private int xSpeed;
	private int ySpeed;
	private static final int height = 10;
	private static final int width = 10;
	private static final Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, width, height);

	// constructor
	public Ball() {
		super(shape);

		// set ball color
		super.setFillColor(Color.RED);
		super.setBorderColor(Color.RED);
		
		// set initial values for x and y position and speed
		xPos = 295;
		yPos = 440;
		xSpeed = 2;
		ySpeed = -2;
	}

	public void move() {
		// move ball
		xPos += xSpeed;
		yPos += ySpeed;
		// detect if ball should bounce off an edge
		if (xPos <= 2) {
			xSpeed = -1*xSpeed;
		}

		if (xPos >= 600 - width) {
			xSpeed = -1*xSpeed;
		}

		if (yPos <= 2) {
			ySpeed = -1*ySpeed;
		}

		// update shape to new values
		shape.setFrame(xPos, yPos, width, height);
	}

	public void setXspeed(int newSpeed) {
		xSpeed = newSpeed;
	}

	public void setYspeed(int newSpeed) {
		ySpeed = newSpeed;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Ellipse2D.Double getShape() {
		return shape;
	}
}