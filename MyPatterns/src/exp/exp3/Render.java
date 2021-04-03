package exp.exp3;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Render {
	private static Render instance;
	private Canvas canvas;
	
	private Render() {
		canvas = null;
	}
	
	public static Render getRender() {
		if(instance == null) {
			synchronized(Render.class) {
				if(instance == null) {
					instance = new Render();
				}
			}
		}
		return instance;
	}

	public void rendering () {
		if(canvas == null) {
			throw new RuntimeException("√ª”–≈‰÷√ª≠≤º!");
		}
		GraphicsContext gc = canvas.getGraphicsContext2D();
		GameManager gm = GameManager.getManager();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.drawImage(gm.getMap().getCurrentLook(), gm.getMap().getPosition().getX(), gm.getMap().getPosition().getY());
		gc.drawImage(gm.getPlayer().getCurrentLook(), gm.getPlayer().getPosition().getX(), gm.getPlayer().getPosition().getY());
		
		for(Coin c:gm.getCoinList()) {
			Point2D pos = c.getPosition();
			Image img = c.getCurrentLook();
			gc.drawImage(img, pos.getX(), pos.getY());
		}
		for(Number n:gm.getNumber()) {
			Point2D pos = n.getPosition();
			Image img = n.getCurrentLook();
			gc.drawImage(img, pos.getX(), pos.getY());
		}
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}
