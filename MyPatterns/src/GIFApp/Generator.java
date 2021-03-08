package GIFApp;

import java.awt.image.BufferedImage;
import java.util.List;

import gif.AnimatedGifEncoder;
import javafx.embed.swing.SwingFXUtils;

public class Generator implements IGeneration {
	AnimatedGifEncoder encoder;
	
	
	public Generator(AnimatedGifEncoder encoder) {
		this.encoder = encoder;
	}
	
	@Override
	public void generate(List<Frame> frames, String outputFile) {
		// TODO Auto-generated method stub
		AnimatedGifEncoder e = new AnimatedGifEncoder();
		e.start(outputFile);
		e.setRepeat(10);
		for(Frame frame:frames) {
			BufferedImage image = SwingFXUtils.fromFXImage(frame.getImage(), null);
			e.setDelay(frame.getDelay());
			e.addFrame(image);
		}
		e.finish();
	}

}
