package GIFApp;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import gif.GifDecoder;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

public class Extractor implements IExtraction {
	private GifDecoder decoder;
	
	public Extractor(GifDecoder decoder) {
		this.decoder = decoder;
	}

	@Override
	public List<Frame> extract(String fileName) {
		
		int status = decoder.read(fileName);
		System.out.println("¶ÁÈ¡×´Ì¬£º" + status);
		int n = decoder.getFrameCount();
		List<Frame> frameList = new ArrayList<Frame>();
		for (int i = 0; i < n; i++) {
			Frame frame = new Frame();
			BufferedImage buffImage = decoder.getFrame(i);
			WritableImage img = SwingFXUtils.toFXImage(buffImage, null);
			int t = decoder.getDelay(i);
			frame.setImage(img);
			frame.setDelay(t);
			frameList.add(frame);
		}
		return frameList;
	}

	public GifDecoder getDecoder() {
		return decoder;
	}

	public void setDecoder(GifDecoder decoder) {
		this.decoder = decoder;
	}

}
