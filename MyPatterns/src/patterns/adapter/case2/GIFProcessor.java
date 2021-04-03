package patterns.adapter.case2;

import java.awt.image.BufferedImage;
import java.io.File;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class GIFProcessor implements IGIFProcessor {
	private GifDecoder gdc;
	
	public GIFProcessor() {
		gdc = new GifDecoder();
	}

	@Override
	public Image[] extract(String gifPath) {
		gdc.read(gifPath);
		int n = gdc.getFrameCount();
		Image[] images = new Image[n];
		for (int i = 0; i < n; i++) {
			BufferedImage frame = gdc.getFrame(i);
			images[i] = SwingFXUtils.toFXImage(frame, null);
		}
		return images;
	}
	
	public GifDecoder getGdc() {
		return gdc;
	}

	public void setGdc(GifDecoder gdc) {
		this.gdc = gdc;
	}

}
