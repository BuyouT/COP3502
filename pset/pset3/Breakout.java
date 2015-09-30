import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Breakout {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,500);
        frame.setTitle("Breakout");
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.setVisible(true);

	}

	private static class GamePanel extends JPanel {
		
		Ball ball;
		Paddle paddle;
		BrickConfiguration bconfig;
		Timer timer;
		ImageIcon background;
		int score;

		public GamePanel() {
			super();

			// call initializeGameObjects()
			initializeGameObjects();
			// add PaddleMover as a keyListener
			addKeyListener(new PaddleMover());
			setFocusable(true);	
			background = new ImageIcon("background.jpg");
			score = 0;	
		}

		public void initializeGameObjects() {
			// instantiate ball, paddle, and brick configuration
			ball = new Ball();
			paddle = new Paddle();
			bconfig = new BrickConfiguration();

			// set up timer to run GameMotion() every 10ms
			timer = new Timer(10, new GameMotion());
			timer.start();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
		
			// paint ball, paddle, and brick configuration
			g2.drawImage(background.getImage(),0,0,null);
			bconfig.paint(g2);
			paddle.paint(g2);
			ball.paint(g2);
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Serif", Font.PLAIN, 20));
			g2.drawString("Score: " + score, 15,20);
			if (ball.getY() > 500) {
				g2.setColor(Color.WHITE);
				g2.setFont(new Font("Serif", Font.PLAIN, 30));
				g2.drawString("Game Over!", 200, 300);
				g2.drawString("Your final score was " + score, 150, 330);
				timer.stop();
			}
		}

		private class GameMotion implements ActionListener {
			public GameMotion() {

			}

			public void actionPerformed(ActionEvent evt) {
				//move ball automatically
				ball.move();

				//move paddle according to key press
				paddle.move();
				
				//check if the ball hits the paddle or a brick
				checkForHit();				
				
				//call repaint
				repaint();
			}
		}


		private class PaddleMover implements KeyListener {
			public void keyPressed(KeyEvent evt) {
				// change paddle speeds for left and right key presses
				int key = evt.getKeyCode();
				

				if (key == KeyEvent.VK_LEFT) {
					paddle.setSpeed(-2);
					
				}
				else if (key == KeyEvent.VK_RIGHT) {
					paddle.setSpeed(2);
				}

			}
			public void keyReleased(KeyEvent evt) {
				// set paddle speed to 0
				int key = evt.getKeyCode();
				if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)) {
					paddle.setSpeed(0);
				}
			}
			public void keyTyped(KeyEvent evt) {}
		}

		public void checkForHit() {
			
			// change ball speed when ball hits paddle
			if (ball.getShape().intersects(paddle.getShape())) {
				int leftSide = paddle.getX();
				int middleLeft = paddle.getX() + (int)(paddle.getWidth()/3);
				int middleRight = paddle.getX() + (int)(2*paddle.getWidth()/3);
				int rightSide = paddle.getX() + paddle.getWidth();

				if ((ball.getX() >= leftSide) && (ball.getX() < middleLeft)) {
					// change ball speed
					ball.setXspeed(-2);
					ball.setYspeed(-2);
				}
				if ((ball.getX() >= middleLeft) && (ball.getX() <= middleRight)) {
					// change ball speed
					ball.setYspeed(-2);
				}
				if ((ball.getX() > middleRight) && (ball.getX() <= rightSide)) {
					// change ball speed
					ball.setXspeed(2);
					ball.setYspeed(-2);
				}
			}

			// change ball speed when ball hits brick
			for (int i = 0; i < bconfig.getRows(); i++) {
				for (int j = 0; j < bconfig.getCols(); j++) {
					if (bconfig.exists(i,j)) {
						if (ball.getShape().intersects(bconfig.getBrick(i,j).getShape())) {
							Point ballLeft = new Point((int)ball.getShape().getX(), (int)(ball.getShape().getY() + ball.getShape().getHeight()/2));
							Point ballRight = new Point((int)(ball.getShape().getX() + ball.getShape().getWidth()), (int)(ball.getShape().getY() + ball.getShape().getHeight()/2));
							Point ballTop = new Point((int)(ball.getShape().getX() + ball.getShape().getWidth()/2), (int)ball.getShape().getY());
							Point ballBottom = new Point((int)(ball.getShape().getX() + ball.getShape().getWidth()/2), (int)(ball.getShape().getY() + ball.getShape().getHeight()));
							if (bconfig.getBrick(i,j).getShape().contains(ballLeft)) {
								// change ball speed
								ball.setXspeed(2);
								score++;
							}
							else if(bconfig.getBrick(i,j).getShape().contains(ballRight)) {
								// change ball speed
								ball.setXspeed(-2);
								score++;
							}
							if (bconfig.getBrick(i,j).getShape().contains(ballTop)) {
								// change ball speed
								ball.setYspeed(2);
								score++;
							}
							else if (bconfig.getBrick(i,j).getShape().contains(ballBottom)) {
								// change ball speed
								ball.setYspeed(-2);
								score++;
							}
							

							// remove brick
							bconfig.removeBrick(i,j);
						}
					}
				}
			}
		}
	}
}