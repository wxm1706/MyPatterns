package patterns.afp.case1;

import java.io.File;

import game.DynamicImage;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class PixelFactory implements IFactory {

	@Override
	public Role createRole(File resource) {
		PixelRole r = new PixelRole();
		Image img = new Image(resource.toURI().toString());
		double width = img.getWidth() / 3;
		double height = img.getHeight() / 4;
		PixelReader pr = img.getPixelReader();
		DynamicImage[] walkImages = new DynamicImage[4];
		for(int i = 0; i < 4; i++) {
			walkImages[i] = new DynamicImage();
			for(int j = 0; j < 3; j++) {
				walkImages[i].add(new WritableImage(pr, j * (int)width, i * (int)height, (int)width, (int)height));
			}
		}
		r.setDownImages(walkImages[0]);
		r.setLeftImages(walkImages[1]);
		r.setRightImages(walkImages[2]);
		r.setUpImages(walkImages[3]);		
		return r;
	}

	@Override
	public Effect createEffect(File resource) {
		Image img = new Image(resource.toURI().toString());
		PixelReader pr = img.getPixelReader();
		DynamicImage tempImage = new DynamicImage();
		double width = 64;
		double height = 64;
		for(int i = 0; i < 7; i++) {
			tempImage.add(new WritableImage(pr, i * (int)width, 0, (int)width, (int)height));
		}
		PixelEffect e = new PixelEffect(tempImage);
		return e;
	}

}
