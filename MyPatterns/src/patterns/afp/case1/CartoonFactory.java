package patterns.afp.case1;

import java.io.File;

import game.DynamicImage;
import game.ImageTool;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class CartoonFactory implements IFactory {

	@Override
	public Role createRole(File resource) {
		DynamicImage rImg = new DynamicImage();
		DynamicImage lImg = new DynamicImage();
		//System.out.println(resource.getAbsolutePath());
		for(File f:resource.listFiles()) {
			Image img = new Image(f.toURI().toString());
			rImg.add(img);
			lImg.add(ImageTool.rotate(img, 180, Rotate.Y_AXIS));
		}
		CartoonRole r = new CartoonRole(rImg, lImg);
		return r;
	}

	@Override
	public Effect createEffect(File resource) {
		DynamicImage dimg = new DynamicImage();
		for(File f:resource.listFiles()) {
			Image img = new Image(f.toURI().toString());
			dimg.add(img);
		}
		CartoonEffect e = new CartoonEffect(dimg);
		return e;
	}

}
