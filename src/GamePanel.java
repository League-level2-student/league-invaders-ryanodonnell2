import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = 0;
	int score;
	Font titleFont;
	Font subtitleFont;
	Font titleFontunbold;
	Font subtitleFontunbold;
	Rocketship ship;
	ObjectManager manager;

	
	public static BufferedImage alienImg;

    public static BufferedImage rocketImg;

    public static BufferedImage bulletImg;

    public static BufferedImage spaceImg;
	// JesusChrist123!

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.BOLD, 48);
		subtitleFont = new Font("Arial", Font.BOLD, 24);
		titleFontunbold = new Font("Arial", Font.PLAIN, 48);
		subtitleFontunbold = new Font("Arial", Font.PLAIN, 24);
		ship = new Rocketship(250, 700, 50, 50, 10);
		manager = new ObjectManager(ship);
		 try {

             alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

             rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

             bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

             spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     }
	}

	void updateMenuState() {
		manager.GetScore();
	}

	void updateGameState() {
		manager.checkCollison();
		manager.purgeObjects();
		manager.update();
		manager.manageEnemies();

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 135, 350);
		g.drawString("Press SPACE for instructions", 100, 500);
		manager.SetScore(0);
	}

	void drawGameState(Graphics g) {
		g.drawImage(GamePanel.spaceImg, 0, 0, 500, 800, null);
		manager.draw(g);
		if (ship.isAlive == false) {
			currentState = END_STATE;
		}
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFontunbold);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 125, 200);
		g.setFont(subtitleFontunbold);
		g.drawString("You killed " + manager.GetScore() + " enemies", 145, 350);
		if(score > manager.GetHighScore()) {
			score= manager.GetHighScore();
			g.drawString("HIGH SCORE!", 145, 400);
		
		}
		g.drawString("Press ENTER to restart", 125, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
	}

	void startGame() {
		timer.start();
	}

	@Override

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println('1');
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState >= END_STATE) {
				currentState = MENU_STATE;
			} else {
				currentState++;
			}
			if (currentState == MENU_STATE) {
				ship.isAlive = true;
				manager = new ObjectManager(ship);
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.rightPressed = true;
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.leftPressed = true;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.downPressed = true;
		} else if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			ship.upPressed = true;
		}
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println('2');
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.rightPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.leftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.downPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.upPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Projectile p = new Projectile(ship.x + ship.width / 2 - 5, ship.y, 10, 10);
			manager.addProjectile(p);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println('3');
	}
}
