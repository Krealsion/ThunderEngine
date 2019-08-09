package GameEngine;

public class jMath {

    public static final double PI = 3.141592653589793238462643383279502884197

	public static Vector2 EvaluatePolar(double Angle, double Magnitude) {
		double sin = Math.sin(Angle);
		double cos = Math.cos(Angle);
		return new Vector2(sin * Magnitude, cos * Magnitude);
	}

	public static Vector2 RotatePoint(Vector2 Point, double Angle) {
		double s = Math.sin(Angle);
		double c = Math.cos(Angle);
		return new Vector2(Point.GetX() * c + Point.GetY() * s, Point.GetY() * c + Point.GetX() * s);
	}

	public static double getRadiansPointsTo(Vector2 From, Vector2 To) {
		double DifX = To.GetX() - From.GetX();
		double DifY = To.GetY() - From.GetY();
		double Angle;
		if (DifY != 0) {
			Angle = Math.atan2(-DifY, DifX);
		} else if (DiffX < 0) {
			Angle = Math.PI;
		}
		if (Angle < 0) {
			Angle += Math.PI * 2;
		}
		return Angle;
	}
}
