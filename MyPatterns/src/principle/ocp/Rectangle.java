package principle.ocp;

public class Rectangle extends Geometry{
	private double width = 1.0;
	private double height = 1.0;

	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public String toString() {
		return "Rectangle: " + getArea();
	}
}
