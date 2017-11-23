package Logic;

import com.badlogic.gdx.math.Vector2;

public class Clipping {
	int minX, minY, maxX, maxY;
	public float Mx, My;

	public Clipping(Vector2 v1, Vector2 v2) {
		minX = (int) v1.x;
		minY = (int) v1.y;
		maxX = (int) v2.x;
		maxY = (int) v2.y;
	}

	public int Codificar(Vector2 p) {
		int Cp = 0;
		int  pX = (int) p.x, pY = (int) p.y;

		if (pY > maxY) {
			Cp += 1000;
		} else {
			if (pY < minY) {
				Cp += 100;
			}
		}
		if (pX > maxX) {
			Cp += 10;
		} else {
			if (pX < minX) {
				Cp += 1;
			}
		}

		return Cp;
	}

	public Vector2 Clip(Vector2 p, int Cp) {
		if(Cp % 10 == 1) {
			p.y = Mx * (minX - p.x) + p.y;
			p.x = minX;
		}else{
			if(((Cp % 100) / 10) == 1) {
				p.y = Mx * (maxX - p.x) + p.y;
				p.x = maxX;
			}else {
				if(((Cp % 1000) / 100) == 1) {
					p.x = My * (minY - p.y) + p.x;
					p.y = minY;
				}else {
					p.x = My * (maxY - p.y) + p.x;
					p.y = maxY;
				}
			}
		}
		
		return p;
	}

}
