package patterns.adapter.case2;

import javafx.scene.image.Image;

public interface IGIFProcessor {
	public Image[] extract(String gifPath);
}
