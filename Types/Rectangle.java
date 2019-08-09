package GameEngine;

public class Rectangle {

	private final int x, y, width, height;

	public int GetX() {
		return x;
	}

	public int GetY() {
		return y;
	}

	public int GetWidth() {
		return width;
	}

	public int GetHeight() {
		return height;
	}

	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean ContainsPoint(Vector2 p) {
		boolean collide = true;
		if (p.GetX() < x) {
			collide = false;
		} else if (p.GetX() > x + width) {
			collide = false;
		} else if (p.GetY() < y) {
			collide = false;
		} else if (p.GetY() > y + height) {
			collide = false;
		}
		return collide;
	}
}
