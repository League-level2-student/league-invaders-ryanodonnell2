import java.awt.Graphics;

public class GameObject {
	int x;

    int y;

    int width;

    int height;
    
    boolean isAlive = true;
    GameObject(int x, int y, int width, int height){
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    }
    void update(int CurX, int CurY) {
    	
    }
    void draw(Graphics g) {
    	
    }
}
