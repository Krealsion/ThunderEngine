package GameEngine;

public class Triangle{
	public Vector2 P1, P2, P3;
	
	public Triangle(Vector2 Pos1, Vector2 Pos2, Vector2 Pos3){
		P1 = Pos1;
		P2 = Pos2;
		P3 = Pos3;
	}
	public Triangle(){
		P1 = new Vector2();
		P2 = new Vector2();
		P3 = new Vector2();
	}
	public Vector2 GetPos1(){
		return P1;
	}
	public Vector2 GetPos2(){
		return P2;
	}
	public Vector2 GetPos3(){
		return P3;
	}
}
