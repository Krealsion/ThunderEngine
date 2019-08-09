package GameEngine;

public class Vector3{
	private double x;
	private double y;
	private double z;
	
	public Vector3(){
		x = 0;
		y = 0;
		z = 0;
	}
	public Vector3(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double GetX(){
		return x;
	}
	public double GetY(){
		return y;
	}
	public double GetZ(){
		return z;
	}
	public void SetX(double x){
		this.x = x;
	}
	public void SetY(double y){
		this.y = y;
	}
	public void SetZ(double z){
		this.z = z;
	}
}
