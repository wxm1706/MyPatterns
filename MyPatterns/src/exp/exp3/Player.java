package exp.exp3;

public class Player extends Entity{
	


	enum DIRECTION{
		LEFT, RIGHT
	}
	public static final int SPEED = 20;
	private int speed = 0;
	private DIRECTION dir = DIRECTION.RIGHT;
	
	private DynamicImage leftLookList;
	private DynamicImage rightLookList;
		
	public Player(DynamicImage leftLookList, DynamicImage rightLookList) {
		super();
		this.leftLookList = leftLookList;
		this.rightLookList = rightLookList;
		setCurrentLook(leftLookList.getImage());
		setWidth(getCurrentLook().getWidth());
		setHeight(getCurrentLook().getHeight());
	}
	
	public void move() {
		DynamicImage lookList = null;
		if(getDir() == DIRECTION.LEFT) {
			lookList = getLeftLookList();
		}else {
			lookList = getRightLookList();
		}
		lookList.nextFrame();
		setCurrentLook(lookList.getImage());
		setPosition(getPosition().add(getSpeed(), 0));
	}
	
	public void right() {
		setSpeed(SPEED);
		setDir(DIRECTION.RIGHT);
	}
	
	public void left() {
		setSpeed(-SPEED);
		setDir(DIRECTION.LEFT);
	}
	
	public void stop() {
		setSpeed(0);
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public DynamicImage getLeftLookList() {
		return leftLookList;
	}


	public void setLeftLookList(DynamicImage leftLookList) {
		this.leftLookList = leftLookList;
	}


	public DynamicImage getRightLookList() {
		return rightLookList;
	}


	public void setRightLookList(DynamicImage rightLookList) {
		this.rightLookList = rightLookList;
	}


	public DIRECTION getDir() {
		return dir;
	}


	public void setDir(DIRECTION dir) {
		this.dir = dir;
	}
}
