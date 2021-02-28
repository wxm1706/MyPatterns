package patterns.afp.case1;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class Effect {
	private Image image;
	private Point2D location;
	
	public Effect() {
		location = new Point2D(0.0, 0.0);
	}
	
	public abstract void change();
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Point2D getLocation() {
		return location;
	}
	public void setLocation(Point2D location) {
		this.location = location;
	}
}
