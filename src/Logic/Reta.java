package Logic;

import com.badlogic.gdx.math.Vector2;

public class Reta {
	public Vector2 inicio;
	public int CInicio;
	public Vector2 fim;
	public int CFim;
	
	public Reta(Vector2 p1, Vector2 p2) {
		CInicio = 0;
		CFim = 0;
		inicio = p1;
		fim = p2;
	}
	public Reta(int x1, int y1, int x2, int y2) {
		CInicio = 0;
		CFim = 0;
		inicio = new Vector2(x1, y1);
		fim = new Vector2(x2, y2);
	}
	
}
