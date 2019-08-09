package GameEngine;

public class Angle{
	private final double Angle;
	private final double Mod;
	public Angle(double Angle, double Addition){
		this.Angle = Angle;
		Mod = Addition;
	}
	public double GetAngle(){
		return Angle;
	}
	public double GetAddition(){
		return Mod;
	}
}
