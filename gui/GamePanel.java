package GameEngine;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private final StateManager Controller;

	private int FPS = 60;	//This is the Target FPS, not actual
	private long TargetTime = 1000 / FPS;
	
	public GamePanel(StateManager Controller) {
		this.Controller = Controller;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, Renderer.WindowWidth, Renderer.WindowWidth);
		Controller.Draw(g);
	}

	public void run() {
		long start, elapsed, wait;

		while (Controller.IsRunning()) {
			start = System.nanoTime();
			
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = TargetTime - elapsed / 1000000;

			if (wait <=0) {
				wait = 5;
			}
			try{
				Thread.sleep(wait);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
