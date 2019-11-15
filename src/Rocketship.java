import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	boolean rightPressed = false;
	boolean leftPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;
	int speed;
	Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, x, y, width, height);
		this.speed = speed;
	}

	void update() {
	super.update(x, y, x, y, width, height);
	move();
	}
	void move() {
		if(leftPressed == true) {
			if(x>0) {
			x = x-speed;
			}
		}
		if(rightPressed == true) {
			if(x<450) {
				x = x+speed;
				}
		}
		if(upPressed == true) {
			if(y>0) {
				y = y-speed;
				}
		}
		if(downPressed == true) {
			if(y<750) {
				y = y+speed;
				}
		}
	}
	void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	     g.fillRect(x, y, width, height);
	}
}
