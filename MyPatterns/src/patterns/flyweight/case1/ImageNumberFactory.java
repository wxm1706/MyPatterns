package patterns.flyweight.case1;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import game.ImageTool;
import javafx.scene.image.Image;

public class ImageNumberFactory {
	private static final ImageNumberFactory instance = new ImageNumberFactory();
	Map<String, Image> numbers = new HashMap<String, Image>();
	
	private ImageNumberFactory() {}
	
	public static ImageNumberFactory getInstance() {
		return instance;
	}
	
	public Image get(String key) {
		if(numbers.containsKey(key)) {
			return numbers.get(key);
		}else {
			int i = Integer.parseInt(key);
			Image img = new Image(Paths.get("bin/images/res/res04.png").toUri().toString());
			img = ImageTool.clipImage(img, 36 * i, 0, 36, 40);
			numbers.put(key, img);
			return img;
		}
	}
}
