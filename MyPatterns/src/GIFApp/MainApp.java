package GIFApp;

import java.util.List;

import gif.AnimatedGifEncoder;
import gif.GifDecoder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primary) throws Exception {
		VBox b = new VBox();
		ScrollPane p = new ScrollPane();
		p.setContent(b);
		p.setMaxSize(200, 200);
		
		Extractor extractor = new Extractor(new GifDecoder());
		Generator generator = new Generator(new AnimatedGifEncoder());
		
		List<Frame> frames = extractor.extract("C:\\Users\\wxm1706\\Desktop\\duitang.gif");
		for(Frame f:frames) {
			//System.out.println("111");
			b.getChildren().addAll(new ImageView(f.getImage()), new Text(String.valueOf(f.getDelay())));
		}
		
		generator.generate(frames, "test.gif");
		
		
		primary.setScene(new Scene(p));
		primary.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
