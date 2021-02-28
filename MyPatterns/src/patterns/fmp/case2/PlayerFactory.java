package patterns.fmp.case2;

import java.io.File;

import game.DynamicImage;
import game.ImageTool;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class PlayerFactory implements IFactory {

	@Override
	public Role create(File resource) {
		DynamicImage rImg = new DynamicImage();
		DynamicImage lImg = new DynamicImage();
		System.out.println(resource.getAbsolutePath());
		for(File f:resource.listFiles()) {
			Image img = new Image(f.toURI().toString());
			rImg.add(img);
			lImg.add(ImageTool.rotate(img, 180, Rotate.Y_AXIS));
		}
		Player p = new Player(rImg, lImg);
		return p;
	}

	
}
