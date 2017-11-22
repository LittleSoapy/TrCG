package Logic;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class AlgoDeBrese {
	
	public void printDot(ShapeRenderer shapeRenderer, int x, int y) {
		if((x >= 200 && x <= 400) && (y >= 200 && y <= 400)) {
			shapeRenderer.setColor(1, 0, 0, 1);
			shapeRenderer.line((float) x, (float) y, (float) x + 1, (float) y + 1);	
		}else {
			shapeRenderer.setColor(0, 0, 1, 1);
			shapeRenderer.line((float) x, (float) y, (float) x + 1, (float) y + 1);	
		}
			
	}
	
	public void quadrado(ShapeRenderer shapeRenderer, Vector2 v1, Vector2 v2) {
		int minX = (int) v1.x, 
				minY = (int) v1.y,
				maxX = (int) v2.x,
				maxY = (int) v2.y;
		Bresenham(shapeRenderer, new Vector2(minX, minY), new Vector2(maxX, minY));
		Bresenham(shapeRenderer, new Vector2(maxX, minY), new Vector2(maxX, maxY));
		Bresenham(shapeRenderer, new Vector2(maxX, maxY), new Vector2(minX, maxY));
		Bresenham(shapeRenderer, new Vector2(minX, maxY), new Vector2(minX, minY));
	}
	
	public void Bresenham(ShapeRenderer shapeRenderer, Vector2 v1, Vector2 v2) {
		int x0 = (int) v1.x, 
				y0 = (int) v1.y,
				x1 = (int) v2.x,
				y1 = (int) v2.y;
		if (Math.abs(x1 - x0) >= Math.abs(y1 - y0)) {
			if (x0 > x1) {
				Bresenham(shapeRenderer, v2, v1);
				return;
			}
			int slope;
			int dx, dy, incrE, incrNE, d, x, y;
			dx = x1 - x0;
			dy = y1 - y0;

			if (dy < 0) {
				slope = -1;
				dy = -dy;
			} else {
				slope = 1;
			}

			d = dy * 2 - dx;
			incrE = dy * 2;
			incrNE = (dy - dx) * 2;
			x = x0;
			y = y0;
			printDot(shapeRenderer, x, y);
			while (x <= x1) {
				if (d <= 0) {
					d += incrE;
					x++;
				} else {
					d += incrNE;
					x++;
					y += slope;
				}
				printDot(shapeRenderer, x, y);
			}
		}else {
			if (y0 > y1) {
				Bresenham(shapeRenderer, v2, v1);
				return;
			}
			
			int slope;
			int dx, dy, incrN, incrNE, d, x, y;
			dx = x1 - x0;
			dy = y1 - y0;
			
			if (dx < 0) {
				slope = -1;
				dx = -dx;
			} else {
				slope = 1;
			}
			
			d = dx * 2 - dy;
			incrN = dx * 2;
			incrNE = (dx - dy) * 2;
			x = x0;
			y = y0;
			printDot(shapeRenderer, x, y);
			while (y <= y1) {
				if (d <= 0) {
					d += incrN;
					y++;
				} else {
					d += incrNE;
					y++;
					x += slope;
				}
				printDot(shapeRenderer, x, y);
			}
		}
	}
	
}
