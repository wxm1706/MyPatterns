package GIFApp;

import javafx.scene.image.Image;

public class Frame {
	private Image image;
	private int delay;
	
	public Frame() {}
	public Frame(Image image, int delay) {
		this.image = image;
		this.delay = delay;
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
