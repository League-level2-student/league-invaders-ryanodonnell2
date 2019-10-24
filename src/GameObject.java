import java.awt.Graphics;

public class GameObject {
	int x;

    int y;

    int width;

    int height;
    GameObject(int x, int y, int width, int height){
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    }
    void update(int CurX, int CurY) {
    int x = CurX;
    int y = CurY;
    }
    void draw(Graphics g) {
    	g.fillRect(x, y, 100, 100);
    }
}
