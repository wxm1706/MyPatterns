package patterns.afp.case1;

import game.DynamicImage;

public class CartoonEffect extends Effect {
	DynamicImage images;
	
	public CartoonEffect(DynamicImage dimg) {
		images = dimg;
	}
		
	@Override
	public void change() {
		images.nextFrame();
		setImage(images.getImage());
	}

}
