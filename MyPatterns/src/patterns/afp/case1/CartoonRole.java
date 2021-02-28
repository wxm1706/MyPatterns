package patterns.afp.case1;

import game.DynamicImage;

public class CartoonRole extends Role{
	DynamicImage rightImages;
	DynamicImage leftImages;
	Direction dir = Direction.RIGHT;

	public CartoonRole(DynamicImage rightImages, DynamicImage leftImages) {
		super();
		this.rightImages = rightImages;
		this.leftImages = leftImages;
	}
	
	@Override
	public void move() {
		double moveX = 0;
		if(dir.equals(Direction.RIGHT)) {
			if(getLocation().getX() < 400) {
				moveX = 10;
				rightImages.nextFrame();
				setImage(rightImages.getImage());
			}else {
				dir = Direction.LEFT;
			}
		}else {
			if(getLocation().getX() > 100) {
				moveX = -10;
				leftImages.nextFrame();
				setImage(leftImages.getImage());
			}else {
				dir = Direction.RIGHT;
			}
		}
		setLocation(getLocation().add(moveX, 0.0));
	}

}
