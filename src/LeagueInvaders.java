import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int width = 500;
	final int height = 800;
	
	public static void main(String[] args) {
		new LeagueInvaders().setup();
	}
	
	LeagueInvaders(){
		 frame = new JFrame();
	}
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(new Dimension(width, height));
		frame.pack();
	}
	
}
