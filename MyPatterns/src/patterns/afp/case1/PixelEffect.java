package patterns.afp.case1;

import game.DynamicImage;

public class PixelEffect extends Effect {
	
	DynamicImage images;
	
	public PixelEffect(DynamicImage dimg) {
		images = dimg;
	}
		
	@Override
	public void change() {
		images.nextFrame();
		setImage(images.getImage());
	}
	
}
