package patterns.fmp.case2;

import java.io.File;

import game.DynamicImage;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class MonsterFactory implements IFactory {

	@Override
	public Role create(File resource) {
		Monster m = new Monster();
		Image img = new Image(resource.toURI().toString());
		double width = img.getWidth() / 4;
		double height = img.getHeight() / 4;
		PixelReader pr = img.getPixelReader();
		DynamicImage[] walkImages = new DynamicImage[4];
		for(int i = 0; i < 4; i++) {
			walkImages[i] = new DynamicImage();
			for(int j = 0; j < 4; j++) {
				walkImages[i].add(new WritableImage(pr, j * (int)width, i * (int)height, (int)width, (int)height));
			}
		}
		m.setDownImages(walkImages[0]);
		m.setLeftImages(walkImages[1]);
		m.setRightImages(walkImages[2]);
		m.setUpImages(walkImages[3]);
		return m;
	}

}
