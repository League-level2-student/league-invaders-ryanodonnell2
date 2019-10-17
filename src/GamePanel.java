import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	Timer timer;
	//JesusChrist123!

	GamePanel(){
		timer = new Timer(1000/60, this);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
		
	}
	void startGame() {
		timer.start();
	}
	@Override

	public void paintComponent(Graphics g){
		g.fillRect(10, 10, 100, 100);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println('1');
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println('2');
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println('3');
	}
}
 