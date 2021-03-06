package exp.exp4;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Transform;

public class Render {
	public static Image rendering(Canvas canvas, Frame f, String text) {
		if(f != null) {
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.drawImage(f.getImage(), 0, 0, canvas.getWidth(), canvas.getHeight());
			if(text != null) {
				gc.save();
				gc.setFill(Color.BLUE);
				gc.setStroke(Color.WHITE);
				gc.setFont(new Font(32));
				gc.setLineWidth(2.0);
				//gc.strokeText(text, 0, 0);
				gc.strokeText(text, canvas.getWidth() / 2 - 32 * text.length() / 2, canvas.getHeight() - 32);
				gc.fillText(text, canvas.getWidth() / 2 - 32 * text.length() / 2, canvas.getHeight() - 32);
				gc.restore();
			}
			SnapshotParameters sp =  new SnapshotParameters();
			//sp.setTransform(Transform.scale(0.2, 0.2));
			//System.out.println(canvas.getWidth());
			return canvas.snapshot(sp, null);
		}
		return null;
	}
}
