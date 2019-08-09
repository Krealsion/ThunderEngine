package GameEngine;

public class Vector2 {

	private double x;
	private double y;

	public Vector2() {
		x = 0;
		y = 0;
	}

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double GetX() {
		return x;
	}

	public double GetY() {
		return y;
	}

	public void SetX(double x) {
		this.x = x;
	}

	public void SetY(double y) {
		this.y = y;
	}

	public void Add(Vector2 o) {
		x += o.GetX();
		y += o.GetY();
	}

	public void AddX(double x) {
		this.x += x;
	}

	public void AddY(double y) {
		this.y += y;
	}
	public void Scale(double Factor){
		x *= Factor;
		y *= Factor;
	}

	@Override
	public String toString() {
		return "(" + GetX() + ", " + GetY() + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (o instanceof Vector2) {
			Vector2 other = (Vector2) o;
			if (Math.abs(other.GetX() - x) > .0001) {
				return false;
			}
			if (Math.abs(other.GetY() - y) > .0001) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 29 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
		hash = 29 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
		return hash;
	}
}
