package exp.exp3;


import javafx.geometry.Point2D;

public class Coin extends Entity implements Cloneable{
	private DynamicImage lookList;
	private int speed = 10;
	
	
	public Coin(DynamicImage lookList) {
		super();
		setLookList(lookList);
		setCurrentLook(lookList.getImage());
		setPosition(new Point2D(0, 0));
		setWidth(getCurrentLook().getWidth());
		setHeight(getCurrentLook().getHeight());
	}
	
	public void move() {
		lookList.nextFrame();
		setCurrentLook(lookList.getImage());
		setPosition(getPosition().add(0, getSpeed()));
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Coin c = (Coin) super.clone();
		c.setLookList((DynamicImage) this.getLookList().clone());
		return c;
	}


	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public DynamicImage getLookList() {
		return lookList;
	}

	public void setLookList(DynamicImage lookList) {
		this.lookList = lookList;
	}
}
