package patterns.fmp.case2;

import game.DynamicImage;

public class Monster extends Role {
	DynamicImage upImages;
	DynamicImage downImages;
	DynamicImage leftImages;
	DynamicImage rightImages;
	Direction dir = Direction.UP;
	
	public Monster() {
		super(100, 200);
	}
	
	@Override
	public void move() {
		double maxX = 400;
		double minX = 100;
		double maxY = 500;
		double minY = 200;
		double moveX = 0;
		double moveY = 0;
		
		switch(dir) {
			case UP:{
				if(getLocation().getY() > minY) {
					moveY = -10;
					upImages.nextFrame();
					setImage(upImages.getImage());
				}else {
					dir = Direction.RIGHT;
				}
			}break;
			case DOWN:{
				if(getLocation().getY() < maxY) {
					moveY = 10;
					downImages.nextFrame();
					setImage(downImages.getImage());
				}else {
					dir = Direction.LEFT;
				}
			}break;
			case LEFT:{
				if(getLocation().getX() > minX) {
					moveX = -10;
					leftImages.nextFrame();
					setImage(leftImages.getImage());
				}else {
					dir = Direction.UP;
				}
			}break;
			case RIGHT:{
				if(getLocation().getX() < maxX) {
					moveX = 10;
					rightImages.nextFrame();
					setImage(rightImages.getImage());
				}else {
					dir = Direction.DOWN;
				}
			}break;
			default:break;
		}
		setLocation(getLocation().add(moveX, moveY));
	}

	public DynamicImage getUpImages() {
		return upImages;
	}

	public void setUpImages(DynamicImage upImages) {
		this.upImages = upImages;
	}

	public DynamicImage getDownImages() {
		return downImages;
	}

	public void setDownImages(DynamicImage downImages) {
		this.downImages = downImages;
	}

	public DynamicImage getLeftImages() {
		return leftImages;
	}

	public void setLeftImages(DynamicImage leftImages) {
		this.leftImages = leftImages;
	}

	public DynamicImage getRightImages() {
		return rightImages;
	}

	public void setRightImages(DynamicImage rightImages) {
		this.rightImages = rightImages;
	}

}
