package GameEngine;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class GameState implements MouseListener {
	protected Renderer Render;
	protected StateManager Controller;
	public GameState(Renderer Render, StateManager Controller){this.Render = Render; this.Controller = Controller;}
	public abstract void Pause();
	public abstract void Resume();
	public abstract void Draw(Graphics g);
	public abstract void Update();
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
