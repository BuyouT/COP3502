import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Enviroment {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel game = new GamePanel();
		frame.add(game);
		frame.setVisible(true);
	}
	private static class GamePanel extends JPanel {
		
		Bird bird;
		Wall bottomWall;
		Wall topWall;
		int score;
		boolean isDead;
		Timer moverTimer;
		Timer scoreTimer;
		public GamePanel() {
			bird = new Bird();
			bottomWall = new Wall(600);
			topWall = new Wall(1000);
			score = 0;
			isDead = false;
			moverTimer = new Timer(30, new GameMotion());
			moverTimer.start();
			scoreTimer = new Timer(2400, new ScoreCounter());
			scoreTimer.start();
			addKeyListener(new KeyAdapter());
			setFocusable(true);
		}
		private class KeyAdapter implements KeyListener {
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
				if (key == KeyEvent.VK_SPACE) {
					bird.jump();
				}
			}
			public void keyReleased(KeyEvent evt) {}
			public void keyTyped(KeyEvent evt) {}
		}
		private class GameMotion implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				topWall.move();
				bottomWall.move();
				bird.move();
				checkForHit();
				repaint();
			}
		}
		private class ScoreCounter implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				score += 1;
			}
		}
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			if (isDead) {
				g2.setColor(Color.BLACK);
				g2.setFont(new Font("Serif", Font.PLAIN, 30));
				g2.drawString("Game Over!", 300, 300);
				g2.drawString("Your final score was " + score, 250, 330);
				moverTimer.stop();
				scoreTimer.stop();
			}
			else {
				topWall.paint(g2);
				bottomWall.paint(g2);
				bird.paint(g2);
				g2.setColor(Color.BLACK);
				g2.setFont(new Font("Serif", Font.PLAIN, 20));
				g2.drawString("Score: " + score, 50,50);
			}
		}
		public void checkForHit() {
			if (topWall.getTopBounds().intersects(bird.getBounds())
			|| bottomWall.getTopBounds().intersects(bird.getBounds())
			|| topWall.getBottomBounds().intersects(bird.getBounds())
			|| bottomWall.getBottomBounds().intersects(bird.getBounds())
			|| bird.getBounds().intersects(new Rectangle2D.Double(0,600,800,10))) {
				isDead = true;
			}
		}
	}
}