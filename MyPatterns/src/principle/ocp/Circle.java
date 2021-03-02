package principle.ocp;

public class Circle extends Geometry{
	private double radius = 1.0;
	
	
	public Circle(double r) {
		radius = r;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "Circle: " + getArea();
	}
}
