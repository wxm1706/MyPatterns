package patterns.fmp.case2;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class Role {
	enum Direction{
		UP, DOWN, LEFT, RIGHT
	}
	private Image image;
	private Point2D location;
	public abstract void move();
	
	public Role() {
		this(0, 0);
	}
	
	public Role(double x, double y) {
		location = new Point2D(x, y);
	}
	
	public Point2D getLocation() {
		return location;
	}
	public void setLocation(Point2D location) {
		this.location = location;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
