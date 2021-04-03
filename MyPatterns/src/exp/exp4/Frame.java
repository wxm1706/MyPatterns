package exp.exp4;

import javafx.scene.image.Image;

public class Frame {
	private Image image;
	private int delay;  // ∫¡√Î
	
	public Frame(Image img, int d) {
		image = img;
		delay = d;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
}
