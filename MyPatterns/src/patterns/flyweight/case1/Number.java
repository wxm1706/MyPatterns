package patterns.flyweight.case1;

import javafx.scene.image.Image;

public class Number {
	private Image image;
	private int number;
	private double x;
	private double y;
	
	public Number(int number) {
		this.setNumber(number);
	}
	
	public Image getImage() {
		return image;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		this.image = ImageNumberFactory.getInstance().get(String.valueOf(number));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
